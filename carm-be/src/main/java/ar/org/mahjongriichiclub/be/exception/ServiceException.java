package ar.org.mahjongriichiclub.be.exception;

public class ServiceException extends LocalizedException {

	private static final long serialVersionUID = 1L;

	
	public ServiceException() {
		super();
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(String messageKey) {
		super(messageKey);
	}
	
	public ServiceException(String messageKey, Throwable cause) {
		super(messageKey, cause);
	}
	
	public ServiceException(String messageKey, String[] params) {
		super(messageKey, params);
	}

	public ServiceException(String messageKey, String[] params, Throwable cause) {
		super(messageKey, params, cause);
	}



}
