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
void _extract_ethernet(uint8_t *dst, uint8_t *hdr) {//pragma [160]
	 uint8_t *src;//pragma [160]
	 src = hdr + 0; //pragma [161]
	 EXTRACT_UINT32(dst, src, 0, 48);//pragma [161]
	 dst += 6;//pragma [161]
	 src = hdr + 6; //pragma [162]
	 EXTRACT_UINT32(dst, src, 0, 48);//pragma [162]
	 dst += 6;//pragma [162]
	 src = hdr + 12; //pragma [163]
	 EXTRACT_UINT32(dst, src, 0, 16);//pragma [163]
	 dst += 4;//pragma [163]

}

void _extract_ipv4(uint8_t *dst, uint8_t *hdr) {//pragma [166]
	 uint8_t *src;//pragma [166]
	 src = hdr + 0; //pragma [167]
	 EXTRACT_UINT32(dst, src, 0, 4);//pragma [167]
	 dst += 4;//pragma [167]
	 src = hdr + 0; //pragma [168]
	 EXTRACT_UINT32(dst, src, 4, 4);//pragma [168]
	 dst += 4;//pragma [168]
	 src = hdr + 1; //pragma [169]
	 EXTRACT_UINT32(dst, src, 0, 8);//pragma [169]
	 dst += 4;//pragma [169]
	 src = hdr + 2; //pragma [170]
	 EXTRACT_UINT32(dst, src, 0, 16);//pragma [170]
	 dst += 4;//pragma [170]
	 src = hdr + 4; //pragma [171]
	 EXTRACT_UINT32(dst, src, 0, 16);//pragma [171]
	 dst += 4;//pragma [171]
	 src = hdr + 6; //pragma [172]
	 EXTRACT_UINT32(dst, src, 0, 3);//pragma [172]
	 dst += 4;//pragma [172]
	 src = hdr + 6; //pragma [173]
	 EXTRACT_UINT32(dst, src, 3, 13);//pragma [173]
	 dst += 4;//pragma [173]
	 src = hdr + 8; //pragma [174]
	 EXTRACT_UINT32(dst, src, 0, 8);//pragma [174]
	 dst += 4;//pragma [174]
	 src = hdr + 9; //pragma [175]
	 EXTRACT_UINT32(dst, src, 0, 8);//pragma [175]
	 dst += 4;//pragma [175]
	 src = hdr + 10; //pragma [176]
	 EXTRACT_UINT32(dst, src, 0, 16);//pragma [176]
	 dst += 4;//pragma [176]
	 src = hdr + 12; //pragma [177]
	 EXTRACT_UINT32(dst, src, 0, 32);//pragma [177]
	 dst += 4;//pragma [177]
	 src = hdr + 16; //pragma [178]
	 EXTRACT_UINT32(dst, src, 0, 32);//pragma [178]
	 dst += 4;//pragma [178]

}

void _extract_standard_metadata(uint8_t *dst, uint8_t *hdr) {//pragma [49]
	 uint8_t *src;//pragma [49]
	 src = hdr + 0; //pragma [50]
	 EXTRACT_UINT32(dst, src, 0, 9);//pragma [50]
	 dst += 4;//pragma [50]
	 src = hdr + 1; //pragma [51]
	 EXTRACT_UINT32(dst, src, 1, 32);//pragma [51]
	 dst += 4;//pragma [51]
	 src = hdr + 5; //pragma [52]
	 EXTRACT_UINT32(dst, src, 1, 9);//pragma [52]
	 dst += 4;//pragma [52]
	 src = hdr + 6; //pragma [53]
	 EXTRACT_UINT32(dst, src, 2, 9);//pragma [53]
	 dst += 4;//pragma [53]
	 src = hdr + 7; //pragma [54]
	 EXTRACT_UINT32(dst, src, 3, 32);//pragma [54]
	 dst += 4;//pragma [54]
	 src = hdr + 11; //pragma [55]
	 EXTRACT_UINT32(dst, src, 3, 32);//pragma [55]
	 dst += 4;//pragma [55]
	 src = hdr + 15; //pragma [56]
	 EXTRACT_UINT32(dst, src, 3, 32);//pragma [56]
	 dst += 4;//pragma [56]
	 src = hdr + 19; //pragma [57]
	 EXTRACT_UINT32(dst, src, 3, 5);//pragma [57]
	 dst += 4;//pragma [57]

}

void _extract_routing_metadata(uint8_t *dst, uint8_t *hdr) {//pragma [156]
	 uint8_t *src;//pragma [156]
	 src = hdr + 0; //pragma [157]
	 EXTRACT_UINT32(dst, src, 0, 32);//pragma [157]
	 dst += 4;//pragma [157]

}

static inline void extract_ethernet(phv_data_t *phv, uint8_t *hdr) { //pragma [160]
  uint8_t *phv_dst = get_phv_ptr(phv, 0); //pragma [160]
  _extract_ethernet(phv_dst, hdr); //pragma [160]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_ethernet); //pragma [160]
}
static inline void extract_ipv4(phv_data_t *phv, uint8_t *hdr) { //pragma [166]
  uint8_t *phv_dst = get_phv_ptr(phv, 16); //pragma [166]
  _extract_ipv4(phv_dst, hdr); //pragma [166]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_ipv4); //pragma [166]
}
static inline void extract_standard_metadata(phv_data_t *phv, uint8_t *hdr) { //pragma [49]
  uint8_t *phv_dst = get_phv_ptr(phv, 64); //pragma [49]
  _extract_standard_metadata(phv_dst, hdr); //pragma [49]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_standard_metadata); //pragma [49]
}
static inline void extract_routing_metadata(phv_data_t *phv, uint8_t *hdr) { //pragma [156]
  uint8_t *phv_dst = get_phv_ptr(phv, 96); //pragma [156]
  _extract_routing_metadata(phv_dst, hdr); //pragma [156]
  phv_set_valid_header(phv, RMT_HEADER_INSTANCE_routing_metadata); //pragma [156]
}

static uint8_t *parser_extract_metadata_full(phv_data_t *phv, uint8_t *pkt) { 
	RMT_LOG(P4_LOG_LEVEL_TRACE, "extracting all metadata for %p\n", pkt);
	extract_standard_metadata(phv, pkt); //pragma [49]
	pkt += 20; //pragma [49]
	extract_routing_metadata(phv, pkt); //pragma [156]
	pkt += 4; //pragma [156]

	return pkt;

}
static uint8_t *parser_extract_metadata(phv_data_t *phv, uint8_t *pkt,
                int *metadata_recirc) {
	RMT_LOG(P4_LOG_LEVEL_TRACE, "extracting metadata\n");
	if(!metadata_recirc) return parser_extract_metadata_full(phv, pkt);
	metadata_recirc_set_t *metadata_set = metadata_recirc_init(metadata_recirc);
	uint8_t *src;
	uint8_t *dst;
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_ingress_port)) { //pragma [50]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_ingress_port\n"); //pragma [50]
		 src = pkt + 0; //pragma  [50]
		 dst = get_phv_ptr(phv, 64); //pragma  [50]
		 EXTRACT_UINT32(dst, src, 0, 9); //pragma  [50]
	}
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_packet_length)) { //pragma [51]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_packet_length\n"); //pragma [51]
		 src = pkt + 1; //pragma  [51]
		 dst = get_phv_ptr(phv, 68); //pragma  [51]
		 EXTRACT_UINT32(dst, src, 1, 32); //pragma  [51]
	}
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_egress_spec)) { //pragma [52]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_egress_spec\n"); //pragma [52]
		 src = pkt + 5; //pragma  [52]
		 dst = get_phv_ptr(phv, 72); //pragma  [52]
		 EXTRACT_UINT32(dst, src, 1, 9); //pragma  [52]
	}
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_egress_port)) { //pragma [53]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_egress_port\n"); //pragma [53]
		 src = pkt + 6; //pragma  [53]
		 dst = get_phv_ptr(phv, 76); //pragma  [53]
		 EXTRACT_UINT32(dst, src, 2, 9); //pragma  [53]
	}
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_egress_instance)) { //pragma [54]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_egress_instance\n"); //pragma [54]
		 src = pkt + 7; //pragma  [54]
		 dst = get_phv_ptr(phv, 80); //pragma  [54]
		 EXTRACT_UINT32(dst, src, 3, 32); //pragma  [54]
	}
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_instance_type)) { //pragma [55]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_instance_type\n"); //pragma [55]
		 src = pkt + 11; //pragma  [55]
		 dst = get_phv_ptr(phv, 84); //pragma  [55]
		 EXTRACT_UINT32(dst, src, 3, 32); //pragma  [55]
	}
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata_clone_spec)) { //pragma [56]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata_clone_spec\n"); //pragma [56]
		 src = pkt + 15; //pragma  [56]
		 dst = get_phv_ptr(phv, 88); //pragma  [56]
		 EXTRACT_UINT32(dst, src, 3, 32); //pragma  [56]
	}
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_standard_metadata__padding)) { //pragma [57]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field standard_metadata__padding\n"); //pragma [57]
		 src = pkt + 19; //pragma  [57]
		 dst = get_phv_ptr(phv, 92); //pragma  [57]
		 EXTRACT_UINT32(dst, src, 3, 5); //pragma  [57]
	}

	pkt += 20;
	if(metadata_recirc_is_valid(metadata_set, RMT_FIELD_INSTANCE_routing_metadata_nhop_ipv4)) { //pragma [157]
		RMT_LOG(P4_LOG_LEVEL_TRACE, "parser_extract_metadata: extracting metadata field routing_metadata_nhop_ipv4\n"); //pragma [157]
		 src = pkt + 0; //pragma  [157]
		 dst = get_phv_ptr(phv, 96); //pragma  [157]
		 EXTRACT_UINT32(dst, src, 0, 32); //pragma  [157]
	}

	pkt += 4;

	free(metadata_set);
	return pkt;
}
	
static inline void build_key_parse_ethernet(phv_data_t *phv,
                  uint8_t *pkt, uint8_t *key) { //pragma [196]
  int byte_offset_phv; //pragma [196]
  uint8_t *pkt_ptr; //pragma [196]

  (void)byte_offset_phv;  /* Compiler reference */ //pragma [196]
  (void)pkt_ptr;  /* Compiler reference */ //pragma [196]
  byte_offset_phv = rmt_field_byte_offset_phv(PHV_GET_FIELD(phv, RMT_FIELD_INSTANCE_ethernet_etherType)); //pragma [196]
  *(uint32_t *) key = phv_buf_field_uint32_get(phv, byte_offset_phv); //pragma [196]
  key += sizeof(uint32_t); //pragma [196]
}

ApplyTableFn parse_state_parse_ethernet(phv_data_t *phv, uint8_t *pkt) { //pragma [194]
  RMT_LOG(P4_LOG_LEVEL_TRACE, "parsing parse_ethernet\n");

  uint8_t *phv_dst; //pragma [194]
  uint8_t *phv_src; //pragma [194]

  (void)phv_src;  /* Compiler reference */ //pragma [194]
  (void)phv_dst;  /* Compiler reference */ //pragma [194]

  extract_ethernet(phv, pkt); //pragma [195]
  pkt += 14; //pragma [195]
  phv->payload = pkt; //pragma [195]
  uint8_t key[4]; //pragma [196]
  build_key_parse_ethernet(phv, pkt, key); //pragma [196]
  uint8_t *mask_value_0 = NULL; //pragma [197]
  uint8_t case_value_0[4] = { 0 ,0 ,8 , 0 }; //pragma [197]
  if (cmp_values(key, case_value_0, 4, mask_value_0)) { //pragma [197]
      return parse_state_parse_ipv4(phv, pkt); //pragma [197]
  }
  return tables_apply_ipv4_lpm; //pragma [198]

}

ApplyTableFn parse_state_parse_ipv4(phv_data_t *phv, uint8_t *pkt) { //pragma [201]
  RMT_LOG(P4_LOG_LEVEL_TRACE, "parsing parse_ipv4\n");

  uint8_t *phv_dst; //pragma [201]
  uint8_t *phv_src; //pragma [201]

  (void)phv_src;  /* Compiler reference */ //pragma [201]
  (void)phv_dst;  /* Compiler reference */ //pragma [201]

  extract_ipv4(phv, pkt); //pragma [202]
  pkt += 20; //pragma [202]
  phv->payload = pkt; //pragma [202]
  return tables_apply_ipv4_lpm; //pragma [203]

}

ApplyTableFn parse_state_start(phv_data_t *phv, uint8_t *pkt) { //pragma [205]
  RMT_LOG(P4_LOG_LEVEL_TRACE, "parsing start\n");

  uint8_t *phv_dst; //pragma [205]
  uint8_t *phv_src; //pragma [205]

  (void)phv_src;  /* Compiler reference */ //pragma [205]
  (void)phv_dst;  /* Compiler reference */ //pragma [205]

  return parse_state_parse_ethernet(phv, pkt); //pragma [206]

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
