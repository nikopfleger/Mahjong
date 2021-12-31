package ar.org.mahjongriichiclub.be.constants;


/**
 * @author Niko
 *
 */
public class ServiceExceptionConstants {
	
	public static final String ERROR_PREFIX = "SERVICE.ERROR.";
	
	public static final String STATUS_OK = "OK";
	public static final String STATUS_ERROR = "ERROR";
	
	public static final String CREATE_USER = ERROR_PREFIX + "CREATE.USER";
	
	
	//COUNTRY
	public static final String CREATE_COUNTRY= ERROR_PREFIX + "CREATE.COUNTRY";
	public static final String COUNTRY_DOES_NOT_EXIST = ERROR_PREFIX + "COUNTRY_DOES_NOT_EXIST";
	public static final String COUNTRY_WITH_ID_DOES_NOT_EXIST = ERROR_PREFIX + "COUNTRY_WITH_ID_DOES_NOT_EXIST";

	public static final String CREATE_PLAYER = ERROR_PREFIX + "ERROR_CREATING_PLAYER";

}
