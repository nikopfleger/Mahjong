package ar.org.mahjongriichiclub.be.exception;

public class ServiceException extends LocalizedException {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, String[] newParams) {
		super(message, newParams);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}	
	

}
