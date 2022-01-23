package ar.org.mahjongriichiclub.be.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

	public static String getMessageForLocale(String messageKey, Locale locale) {
		String response = null;
		try {
			response = ResourceBundle.getBundle("messages", locale).getString(messageKey);
		} catch (Exception e) {
			return null;
		}
		return response;
	}

	public static ResourceBundle getMessageResource(Locale locale) {
		return ResourceBundle.getBundle("messages", locale);
	}

}