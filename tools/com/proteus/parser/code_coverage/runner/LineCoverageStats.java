package com.proteus.parser.code_coverage.runner;

import lombok.Data;

@Data
public class LineCoverageStats {
	private String data;
	private Integer executionRate;
	private Integer lineNum;
	private String coverageDetails;
}
