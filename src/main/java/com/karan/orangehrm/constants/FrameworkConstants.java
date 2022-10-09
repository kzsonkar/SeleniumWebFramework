/**
 * 
 */
package com.karan.orangehrm.constants;

/**
 * @author karansonkar
 *
 */
public final class FrameworkConstants {
	
	private FrameworkConstants() {}
	
	private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

}
