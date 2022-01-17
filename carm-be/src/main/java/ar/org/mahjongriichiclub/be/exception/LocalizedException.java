package ar.org.mahjongriichiclub.be.exception;

import java.text.MessageFormat;
import java.util.Locale;

public class LocalizedException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String messageKey;
	private Locale locale;
	private String[] params = null;
	
	public LocalizedException() {
		super();
	}
	
	public LocalizedException(Throwable cause) {
		super(cause);
	}
	
	public LocalizedException(String messageKey) {
		super(messageKey);
	}
	
	public LocalizedException(String messageKey, Throwable cause) {
		super(messageKey, cause);
	}
	
	public LocalizedException(String messageKey, String[] params) {
		super(messageKey);
		this.params = params;
		this.messageKey = messageKey;
	}

	public LocalizedException(String messageKey, String[] params, Throwable cause) {
		super(messageKey, cause);
		this.params = params;
		this.messageKey = messageKey;
	}

	@Override
	@SuppressWarnings("all")
	public String getLocalizedMessage() {
		
		if (params != null && params.length > 0) {
			String resource = Messages.getMessageResource(Locale.getDefault()).getString(messageKey);
			
			return MessageFormat.format(resource,params);
		}
		String returnMessage = Messages.getMessageForLocale(messageKey, Locale.getDefault());
		return returnMessage == null?"ERROR":returnMessage;
	}
	
	@Override
	public String getMessage() {
		return getLocalizedMessage()==null?super.getMessage():getLocalizedMessage();
	}

	@Override
	public String toString() {
		String s = getClass().getName();
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
	
	
}