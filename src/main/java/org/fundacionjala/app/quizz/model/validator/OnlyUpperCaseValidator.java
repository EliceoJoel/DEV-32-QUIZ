

package org.fundacionjala.app.quizz.model.validator;

import java.util.List;


public class OnlyUpperCaseValidator implements Validator {

	private static final String ERROR_MESSAGE = "Only uppercase letters";

    @Override
    public void validate(String value, String conditionValue, List<String> errors) {
        if (!isUpperCase(value)) {
            errors.add(ERROR_MESSAGE);
        }
    }
	
	public static boolean isUpperCase(String value) {
		//Returns the result of comparing the original with its uppercase version
		return value.equals(value.toUpperCase());
	}

}
