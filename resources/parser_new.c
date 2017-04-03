#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "enums.h"
#include "parser.h"
#include "phv.h"
#include "rmt_internal.h"
#include "value_set.h"
#include "metadata_recirc.h"


typedef void (*ExtractionFn)(phv_data_t *phv, uint8_t *hdr);
void _extract_ethernet(uint8_t *dst, uint8_t *hdr) {
       uint8_t *src;
       src = hdr + 0; //pragma [187]
       EXTRACT_UINT32(dst, src, 0, 48);//pragma [187]
       dst += 6;//pragma [187]
       src = hdr + 6; //pragma [188]
       EXTRACT_UINT32(dst, src, 0, 48);//pragma [188]
       dst += 6;//pragma [188]
       src = hdr + 12; //pragma [189]
       EXTRACT_UINT32(dst, src, 0, 16);//pragma [189]
       dst += 4;//pragma [189]

}

void _extract_routing_metadata(uint8_t *dst, uint8_t *hdr) {
       uint8_t *src;
       src = hdr + 0; //pragma [183]
       EXTRACT_UINT32(dst, src, 0, 32);//pragma [183]
       dst += 4;//pragma [183]

}

void _extract_ipv4(uint8_t *dst, uint8_t *hdr) {
       uint8_t *src;
       src = hdr + 0; //pragma [193]
       EXTRACT_UINT32(dst, src, 0, 4);//pragma [193]
       dst += 4;//pragma [193]
       src = hdr + 0; //pragma [194]
       EXTRACT_UINT32(dst, src, 4, 4);//pragma [194]
       dst += 4;//pragma [194]
       src = hdr + 1; //pragma [195]
       EXTRACT_UINT32(dst, src, 0, 8);//pragma [195]
       dst += 4;//pragma [195]
       src = hdr + 2; //pragma [196]
       EXTRACT_UINT32(dst, src, 0, 16);//pragma [196]
       dst += 4;//pragma [196]
       src = hdr + 4; //pragma [197]
       EXTRACT_UINT32(dst, src, 0, 16);//pragma [197]
       dst += 4;//pragma [197]
       src = hdr + 6; //pragma [198]
       EXTRACT_UINT32(dst, src, 0, 3);//pragma [198]
       dst += 4;//pragma [198]
       src = hdr + 6; //pragma [199]
       EXTRACT_UINT32(dst, src, 3, 13);//pragma [199]
       dst += 4;//pragma [199]
       src = hdr + 8; //pragma [200]
       EXTRACT_UINT32(dst, src, 0, 8);//pragma [200]
       dst += 4;//pragma [200]
       src = hdr + 9; //pragma [201]
       EXTRACT_UINT32(dst, src, 0, 8);//pragma [201]
       dst += 4;//pragma [201]
       src = hdr + 10; //pragma [202]
       EXTRACT_UINT32(dst, src, 0, 16);//pragma [202]
       dst += 4;//pragma [202]
       src = hdr + 12; //pragma [203]
       EXTRACT_UINT32(dst, src, 0, 32);//pragma [203]
       dst += 4;//pragma [203]
       src = hdr + 16; //pragma [204]
       EXTRACT_UINT32(dst, src, 0, 32);//pragma [204]
       dst += 4;//pragma [204]

}

void _extract_standard_metadata(uint8_t *dst, uint8_t *hdr) {
       uint8_t *src;
       src = hdr + 0; //pragma [66]
       EXTRACT_UINT32(dst, src, 0, 9);//pragma [66]
       dst += 4;//pragma [66]
       src = hdr + 1; //pragma [67]
       EXTRACT_UINT32(dst, src, 1, 32);//pragma [67]
       dst += 4;//pragma [67]
       src = hdr + 5; //pragma [68]
       EXTRACT_UINT32(dst, src, 1, 9);//pragma [68]
       dst += 4;//pragma [68]
       src = hdr + 6; //pragma [69]
       EXTRACT_UINT32(dst, src, 2, 9);//pragma [69]
       dst += 4;//pragma [69]
       src = hdr + 7; //pragma [70]
       EXTRACT_UINT32(dst, src, 3, 32);//pragma [70]
       dst += 4;//pragma [70]
       src = hdr + 11; //pragma [71]
       EXTRACT_UINT32(dst, src, 3, 32);//pragma [71]
       dst += 4;//pragma [71]
       src = hdr + 15; //pragma [72]
       EXTRACT_UINT32(dst, src, 3, 32);//pragma [72]
       dst += 4;//pragma [72]
       src = hdr + 19; //pragma [73]
       EXTRACT_UINT32(dst, src, 3, 5);//pragma [73]
       dst += 4;//pragma [73]

}

static inline void extract_ethernet(phv_data_t *phv, uint8_t *hdr) {
  uint8_t *phv_dst = get_phv_ptr(phv, 0); //pragma [186-190]
  _extract_ethernet(phv_dst, hdr); //pragma [186-190]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_ethernet); //pragma [186-190]
}
static inline void extract_routing_metadata(phv_data_t *phv, uint8_t *hdr) {
  uint8_t *phv_dst = get_phv_ptr(phv, 96); //pragma [182-184]
  _extract_routing_metadata(phv_dst, hdr); //pragma [182-184]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_routing_metadata); //pragma [182-184]
}
static inline void extract_ipv4(phv_data_t *phv, uint8_t *hdr) {
  uint8_t *phv_dst = get_phv_ptr(phv, 16); //pragma [192-205]
  _extract_ipv4(phv_dst, hdr); //pragma [192-205]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_ipv4); //pragma [192-205]
}
static inline void extract_standard_metadata(phv_data_t *phv, uint8_t *hdr) {
  uint8_t *phv_dst = get_phv_ptr(phv, 64); //pragma [64-74]
  _extract_standard_metadata(phv_dst, hdr); //pragma [64-74]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_standard_metadata); //pragma [64-74]
}

static uint8_t *parser_extract_metadata_full(phv_data_t *phv, uint8_t *pkt) {
       RMT_LOG(P4_LOG_LEVEL_TRACE, "extracting all metadata for %p\n", pkt);
       extract_routing_metadata(phv, pkt); //pragma [182-184]
       pkt += 4; //pragma [182-184]
       extract_standard_metadata(phv, pkt); //pragma [64-74]
       pkt += 20; //pragma [64-74]

       return pkt;

}
static uint8_t *parser_extract_metadata(phv_data_t *phv, uint8_t *pkt,
                int *metadata_recirc) {
       RMT_LOG(P4_LOG_LEVEL_TRACE, "extracting metadata\n");
       if(!metadata_recirc) return parser_extract_metadata_full(phv, pkt);
       metadata_recirc_set_t *metadata_set = metadata_recirc_init(metadata_recirc);
       uint8_t *src;
       uint8_t *dst;
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_routing_metadata_nhop_ipv4)) { //pragma [183]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field routing_metadata_nhop_ipv4\n"); //pragma [183]
              src = pkt + 0; //pragma  [183]
              dst = get_phv_ptr(phv, 96); //pragma  [183]
              EXTRACT_UINT32(dst, src, 0, 32); //pragma  [183]
       }

       pkt += 4;
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_ingress_port)) { //pragma [66]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_ingress_port\n"); //pragma [66]
              src = pkt + 0; //pragma  [66]
              dst = get_phv_ptr(phv, 64); //pragma  [66]
              EXTRACT_UINT32(dst, src, 0, 9); //pragma  [66]
       }
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_packet_length)) { //pragma [67]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_packet_length\n"); //pragma [67]
              src = pkt + 1; //pragma  [67]
              dst = get_phv_ptr(phv, 68); //pragma  [67]
              EXTRACT_UINT32(dst, src, 1, 32); //pragma  [67]
       }
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_egress_spec)) { //pragma [68]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_egress_spec\n"); //pragma [68]
              src = pkt + 5; //pragma  [68]
              dst = get_phv_ptr(phv, 72); //pragma  [68]
              EXTRACT_UINT32(dst, src, 1, 9); //pragma  [68]
       }
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_egress_port)) { //pragma [69]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_egress_port\n"); //pragma [69]
              src = pkt + 6; //pragma  [69]
              dst = get_phv_ptr(phv, 76); //pragma  [69]
              EXTRACT_UINT32(dst, src, 2, 9); //pragma  [69]
       }
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_egress_instance)) { //pragma [70]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_egress_instance\n"); //pragma [70]
              src = pkt + 7; //pragma  [70]
              dst = get_phv_ptr(phv, 80); //pragma  [70]
              EXTRACT_UINT32(dst, src, 3, 32); //pragma  [70]
       }
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_instance_type)) { //pragma [71]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_instance_type\n"); //pragma [71]
              src = pkt + 11; //pragma  [71]
              dst = get_phv_ptr(phv, 84); //pragma  [71]
              EXTRACT_UINT32(dst, src, 3, 32); //pragma  [71]
       }
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_clone_spec)) { //pragma [72]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_clone_spec\n"); //pragma [72]
              src = pkt + 15; //pragma  [72]
              dst = get_phv_ptr(phv, 88); //pragma  [72]
              EXTRACT_UINT32(dst, src, 3, 32); //pragma  [72]
       }
       if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata__padding)) { //pragma [73]
              RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata__padding\n"); //pragma [73]
              src = pkt + 19; //pragma  [73]
              dst = get_phv_ptr(phv, 92); //pragma  [73]
              EXTRACT_UINT32(dst, src, 3, 5); //pragma  [73]
       }

       pkt += 20;

       free(metadata_set);
       return pkt;
}

static inline void build_key_parse_ethernet(phv_data_t *phv,
                  uint8_t *pkt, uint8_t *key) {
  int byte_offset_phv; //pragma [220-226]
  uint8_t *pkt_ptr; //pragma [220-226]

  (void)byte_offset_phv;  /* Compiler reference */ //pragma [220-226]
  (void)pkt_ptr;  /* Compiler reference */ //pragma [220-226]
  byte_offset_phv = rmt_field_byte_offset_phv(PHV_GET_FIELD(phv, RMT_FIELD_INSTANCE_ethernet_etherType)); //pragma [220-226]
  *(uint32_t *) key = phv_buf_field_uint32_get(phv, byte_offset_phv); //pragma [220-226]
  key += sizeof(uint32_t); //pragma [220-226]
}

ApplyTableFn parse_state_parse_ethernet(phv_data_t *phv, uint8_t *pkt) {
  RMT_LOG(P4_LOG_LEVEL_TRACE, "parsing parse_ethernet\n");

  uint8_t *phv_dst;
  uint8_t *phv_src;

  (void)phv_src;  /* Compiler reference */
  (void)phv_dst;  /* Compiler reference */

  extract_ethernet(phv, pkt); //pragma [221]
  pkt += 14; //pragma [221]
  phv->payload = pkt; //pragma [221]
  uint8_t key[4]; //pragma [222-225]
  build_key_parse_ethernet(phv, pkt, key); //pragma [222-225]
  uint8_t *mask_value_0 = NULL; //pragma [223]
  uint8_t case_value_0[4] = { 0 ,0 ,8 , 0 }; //pragma [223]
  if (cmp_values(key, case_value_0, 4, mask_value_0)) { //pragma [223]
      return parse_state_parse_ipv4(phv, pkt); //pragma [223]
  }
  return tables_apply_ipv4_lpm; //pragma [224]

}

ApplyTableFn parse_state_parse_ipv4(phv_data_t *phv, uint8_t *pkt) {
  RMT_LOG(P4_LOG_LEVEL_TRACE, "parsing parse_ipv4\n");

  uint8_t *phv_dst;
  uint8_t *phv_src;

  (void)phv_src;  /* Compiler reference */
  (void)phv_dst;  /* Compiler reference */

  extract_ipv4(phv, pkt); //pragma [228]
  pkt += 20; //pragma [228]
  phv->payload = pkt; //pragma [228]
  return tables_apply_ipv4_lpm; //pragma [229]

}

ApplyTableFn parse_state_start(phv_data_t *phv, uint8_t *pkt) {
  RMT_LOG(P4_LOG_LEVEL_TRACE, "parsing start\n");

  uint8_t *phv_dst;
  uint8_t *phv_src;

  (void)phv_src;  /* Compiler reference */
  (void)phv_dst;  /* Compiler reference */

  return parse_state_parse_ethernet(phv, pkt); //pragma [232]

}

ApplyTableFn parser_parse_pkt(phv_data_t *phv,
               uint8_t *pkt, int len,
               ParseStateFn start){
  phv->payload = pkt;
  ApplyTableFn apply_table_fn = start(phv, pkt);
  phv->payload_len = len - (phv->payload - pkt);
  RMT_LOG(P4_LOG_LEVEL_VERBOSE, "payload length: %d\n", phv->payload_len);
  return apply_table_fn;
}

void parser_parse_metadata(phv_data_t *phv,
            uint8_t *metadata, int *metadata_recirc) {
  parser_extract_metadata(phv, metadata, metadata_recirc);
}
