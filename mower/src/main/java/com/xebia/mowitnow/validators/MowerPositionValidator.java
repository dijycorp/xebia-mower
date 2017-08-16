package com.xebia.mowitnow.validators;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate the values given for the initial position with the pattern : <br>
 * [1-9] [1-9] [a-aA-Z
 * 
 * @author Jeremie.Diacono
 *
 */
public class MowerPositionValidator implements Function<String, Boolean> {

	private Pattern pattern = Pattern.compile("[1-9] [1-9] [a-aA-Z]");

	@Override
	public Boolean apply(String mowerPosition) {
		// match the data
		Matcher matcher = pattern.matcher(mowerPosition);
		// return the result
		return matcher.matches();
	}

}
