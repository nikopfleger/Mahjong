package ar.org.mahjongriichiclub.be.exception;

import java.io.Serializable;

public class ExceptionCauseInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String exceptionClass;
	private String exceptionMessage;
	// FIXME gcampo: Field for extra-information?

	/**
	 * Construct a new ExceptionCauseInformation using the exception class and
	 * localizedMessage for its exceptionClass and exceptionMessage.
	 * 
	 * @param e the exception to take information from.
	 */
	public ExceptionCauseInformation(Exception e) {
		this(e.getClass().getName(), (e.getLocalizedMessage() == null || e.getLocalizedMessage().length() == 0) ? ""
				: e.getLocalizedMessage());
	}

	/**
	 * Construct a new ExceptionCauseInformation
	 * 
	 * @param _exceptionClass the class of the exception that caused the problem
	 * @param _message        the message to display as message exception.
	 */
	public ExceptionCauseInformation(String _exceptionClass, String _message) {
		super();
		this.setExceptionClass(_exceptionClass);
		this.setExceptionMessage(_message);
	}

	public String getExceptionClass() {
		return exceptionClass;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
