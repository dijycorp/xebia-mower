package com.xebia.mowitnow.validators;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate the values given for instructions with the pattern : <br>
 * [ADG]
 * 
 * @author Jeremie.Diacono
 *
 */
public class MowerInstructionValidator implements Function<String, Boolean> {

	private Pattern pattern = Pattern.compile("[A|D|G]*$");

	@Override
	public Boolean apply(String mowerPosition) {
		// match the data
		Matcher matcher = pattern.matcher(mowerPosition);
		// return the result
		return matcher.matches();
	}
}
