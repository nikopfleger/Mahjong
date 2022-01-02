package ar.org.mahjongriichiclub.be.constants;


/**
 * @author Niko
 *
 */
public class ServiceExceptionConstants {
	
	public static final String ERROR_PREFIX = "SERVICE.ERROR.";
	
	public static final String STATUS_OK = "OK";
	public static final String STATUS_ERROR = "ERROR";
	
	public static final String CREATE_USER = ERROR_PREFIX + "CREATE_USER";
	
	
	//COUNTRY
	public static final String CREATE_COUNTRY= ERROR_PREFIX + "CREATE_COUNTRY";
	public static final String COUNTRY_DOES_NOT_EXIST = ERROR_PREFIX + "COUNTRY_DOES_NOT_EXIST";
	public static final String COUNTRY_WITH_ID_DOES_NOT_EXIST = ERROR_PREFIX + "COUNTRY_WITH_ID_DOES_NOT_EXIST";

	public static final String ERROR_CREATING_PLAYER = ERROR_PREFIX + "ERROR_CREATING_PLAYER";
	public static final String ERROR_CREATING_LOCATION = ERROR_PREFIX + "ERROR_CREATING_LOCATION";
	
	public static final String ERROR_SAVING_ENTITY = ERROR_PREFIX + "ERROR_SAVING_ENTITY";

	public static final String INVALID_ONLINE_GAME_VALUE = ERROR_PREFIX + "INVALID_ONLINE_GAME_VALUE";

}
