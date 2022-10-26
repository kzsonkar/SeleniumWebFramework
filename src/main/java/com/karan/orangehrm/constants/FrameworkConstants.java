/**
 * 
 */
package com.karan.orangehrm.constants;

/**
 * @author karansonkar
 *
 */
public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/config.properties";
	private static final String EXCELPATH = RESOURCESPATH + "/TestData-PROD.xlsx";
	private static final String RUNMANGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getRunmangersheet() {
		return RUNMANGERSHEET;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getIterationDataSheet() {
		return ITERATIONDATASHEET;
	}

}
