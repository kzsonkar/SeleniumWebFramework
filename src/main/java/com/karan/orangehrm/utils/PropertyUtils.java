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
import java.util.Objects;
import java.util.Properties;

import com.karan.orangehrm.constants.FrameworkConstants;
import com.karan.orangehrm.enums.ConfigProperties;

/**
 * @author karansonkar
 *
 */
public final class PropertyUtils {

	private PropertyUtils() {
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

	public static String getValue(ConfigProperties key) throws Exception {
		if(Objects.isNull(key.name().toLowerCase()) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " not found in config file");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
