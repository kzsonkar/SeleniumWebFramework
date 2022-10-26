/**
 * 
 */
package com.karan.orangehrm.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.karan.orangehrm.utils.DataProviderUtils;

/**
 * @author karansonkar
 *
 */
public class AnnotationTransformerImpl implements IAnnotationTransformer {

	/**
	 * Transform an IConfiguration annotation.
	 *
	 * <p>
	 * Note that only one of the three parameters testClass, testConstructor and
	 * testMethod will be non-null.
	 *
	 * @param annotation      The annotation that was read from your test class.
	 * @param testClass       If the annotation was found on a class, this parameter
	 *                        represents this class (null otherwise).
	 * @param testConstructor If the annotation was found on a constructor, this
	 *                        parameter represents this constructor (null
	 *                        otherwise).
	 * @param testMethod      If the annotation was found on a method, this
	 *                        parameter represents this method (null otherwise).
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzerImpl.class);
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setDataProvider("getData");
	}

}
