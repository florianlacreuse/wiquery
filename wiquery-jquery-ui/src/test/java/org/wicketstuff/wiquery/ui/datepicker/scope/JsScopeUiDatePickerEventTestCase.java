package org.wicketstuff.wiquery.ui.datepicker.scope;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketstuff.wiquery.core.javascript.JsScopeContext;
import org.wicketstuff.wiquery.core.javascript.JsStatement;
import org.wicketstuff.wiquery.tester.WiQueryTestCase;

/**
 * Unit test on the {@link JsScopeUiDatePickerEvent}
 * 
 * @author Julien Roche
 */
public class JsScopeUiDatePickerEventTestCase extends WiQueryTestCase
{

	protected static final Logger log = LoggerFactory
		.getLogger(JsScopeUiDatePickerEventTestCase.class);

	/**
	 * Check the syntax
	 */
	@Test
	public void testJsScopeSyntax()
	{
		String expectedJavascript = "function(date) {\n\talert('test');\n}";
		JsScopeUiDatePickerEvent scopeUiEvent = new JsScopeUiDatePickerEvent()
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void execute(JsScopeContext scopeContext)
			{
				scopeContext.append("alert('test');");
			}

		};
		String generatedJavascript = scopeUiEvent.render().toString();

		log.info(expectedJavascript);
		log.info(generatedJavascript);

		assertEquals(generatedJavascript, expectedJavascript);

		// Second generation
		generatedJavascript = scopeUiEvent.render().toString();
		log.info(expectedJavascript);
		log.info(generatedJavascript);

		assertEquals(generatedJavascript, expectedJavascript);
	}

	/**
	 * Check the quickScope function
	 */
	@Test
	public void testQuickScope()
	{
		String expectedJavascript = "function(date) {\n\talert('test');\n}";
		JsScopeUiDatePickerEvent quickScope = JsScopeUiDatePickerEvent.quickScope("alert('test');");
		String generatedJavascript = quickScope.render().toString();

		log.info(expectedJavascript);
		log.info(generatedJavascript);

		assertEquals(generatedJavascript, expectedJavascript);

		// Second generation
		generatedJavascript = quickScope.render().toString();

		log.info(expectedJavascript);
		log.info(generatedJavascript);

		assertEquals(generatedJavascript, expectedJavascript);
	}

	/**
	 * Check the quickScope function
	 */
	@Test
	public void testQuickScopeJsStatement()
	{
		String expectedJavascript = "function(date) {\n\talert('test');\n}";
		JsScopeUiDatePickerEvent quickScope = JsScopeUiDatePickerEvent
			.quickScope(new JsStatement().append("alert('test')"));
		String generatedJavascript = quickScope.render().toString();

		log.info(expectedJavascript);
		log.info(generatedJavascript);

		assertEquals(generatedJavascript, expectedJavascript);

		// Second generation
		generatedJavascript = quickScope.render().toString();

		log.info(expectedJavascript);
		log.info(generatedJavascript);

		assertEquals(generatedJavascript, expectedJavascript);
	}

	@Override
	protected Logger getLog()
	{
		return log;
	}
}
