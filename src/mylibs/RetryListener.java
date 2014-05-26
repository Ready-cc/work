package mylibs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * 用例执行失败则重新执行
 */
public class RetryListener implements IAnnotationTransformer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IAnnotationTransformer#transform(org.testng.annotations.
	 * ITestAnnotation, java.lang.Class, java.lang.reflect.Constructor,
	 * java.lang.reflect.Method)
	 */
	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {

		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if (retry == null) {
			// annotation.setRetryAnalyzer(RetryAnalyzer.class);
			// annotation.setRetryAnalyzer(RetryFail.class);
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
		}
	}

}