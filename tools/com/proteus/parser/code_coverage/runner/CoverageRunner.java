package com.proteus.parser.code_coverage.runner;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.proteus.common.util.Utils;

public class CoverageRunner {

	private static final Logger L = LoggerFactory.getLogger(CoverageRunner.class);
	private static JCommander jc = null;
	private static CommandLineParser cp = new CommandLineParser(new File("./").getAbsolutePath());

	public static void main(String[] args) {
		L.info("Launching Coverage Runner");
		runCoverageRunner(args, true);
	}

	public static void printHelp(JCommander jac){
		jac.usage();
	}

	public static void runCoverageRunner(String[] args, boolean systemExitOnException){
		try{
			jc = new JCommander(cp);
			jc.setProgramName("proteus");
			jc.parse(args);
			//cp.processArgs();
			if(cp.isHelp()){
				printHelp(jc);
				System.exit(0);
			}
		}catch(Throwable t){
			printHelp(jc);
			takeCareOfError("Error parsing Arguments",t, systemExitOnException);
		}
		try{
			CoverageRunnerSession session = new CoverageRunnerSession(cp.getOutputFile(), cp.getInputFile(),cp.getCovFile(),cp.getP4File(),cp.getPrettyPrint(),null);
			session.process();
			L.info("Done");
		}catch(Throwable t){
			t.printStackTrace();
			takeCareOfError("Error Running Proteus Session", t, systemExitOnException);
		}
	}

	public static void takeCareOfError(String externalErrorMsg, Throwable t, boolean systemExitOnException) {
		L.error(externalErrorMsg + ": " + Utils.getRootCauseUserDisplayString(t));
		takeCareOfError(new RuntimeException(externalErrorMsg, t), systemExitOnException);
	}

	private static void takeCareOfError(Throwable t, boolean systemExitOnException) {
		if (systemExitOnException)
			System.exit(1);
		else
			throw new RuntimeException(t);
	}

}
