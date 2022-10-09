/**
 * 
 */
package com.karan.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.karan.orangehrm.constants.FrameworkConstants;

import java.util.Objects;
import java.util.Properties;

/**
 * @author karansonkar
 *
 */
public final class ReadPropertyFile {

	private ReadPropertyFile() {
	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(fis);
			for(Entry<Object, Object> entry: property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
			throw new Exception("Property name " + key + " not found in config file");
		}
		return CONFIGMAP.get(key);
	}

}
