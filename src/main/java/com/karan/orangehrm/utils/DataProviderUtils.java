/**
 * 
 */
package com.karan.orangehrm.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.testng.annotations.DataProvider;

import com.karan.orangehrm.constants.FrameworkConstants;

/**
 * @author karansonkar
 *
 */
public class DataProviderUtils {

	private DataProviderUtils() {
	}

	private static List<Map<String, String>> list = new ArrayList<>();

	/**
	 * Acts as a data provider for all the test cases. Parallel=true indicates that
	 * each of the iteration will be ran in parallel.
	 * 
	 * @param m {@link java.lang.reflect.Method} holds the information about the
	 *          testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap
	 *         and each of them contains the test data needed to run the iterations.
	 * 
	 */
	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testname = m.getName();

		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
			//System.out.println(list);
		}
		List<Map<String, String>> smalllist = new ArrayList<>(list);

		Predicate<Map<String, String>> isTestNameNotMatching = map -> !map.get("testname").equalsIgnoreCase(testname);
		Predicate<Map<String, String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");

		smalllist.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
		return smalllist.toArray();

	}

}
