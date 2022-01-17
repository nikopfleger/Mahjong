package ar.org.mahjongriichiclub.be.constants;


/**
 * @author Niko
 *
 */
public class ServiceExceptionConstants {
	
	public static final String ERROR_PREFIX = "SERVICE.ERROR.";
	
	public static final String STATUS_OK = "OK";
	public static final String STATUS_ERROR = "ERROR";
	
	//CREATE
	public static final String CREATING_PERSON = ERROR_PREFIX + "CREATING_PERSON";
	public static final String CREATING_COUNTRY= ERROR_PREFIX + "CREATING_COUNTRY";
	public static final String CREATING_LOCATION = ERROR_PREFIX + "CREATING_LOCATION";
	public static final String CREATING_UMA = ERROR_PREFIX + "CREATING_UMA";	
	public static final String CREATING_PLAYER = ERROR_PREFIX + "CREATING_PLAYER";
	public static final String CREATING_TOURNEY_RESULT = ERROR_PREFIX + "CREATING_TOURNEY_RESULT";
	
	public static final String COUNTRY_DOES_NOT_EXIST = ERROR_PREFIX + "COUNTRY_DOES_NOT_EXIST";
	public static final String COUNTRY_WITH_ID_DOES_NOT_EXIST = ERROR_PREFIX + "COUNTRY_WITH_ID_DOES_NOT_EXIST";
	
	public static final String SAVING_ENTITY = ERROR_PREFIX + "SAVING_ENTITY";

	public static final String INVALID_ONLINE_GAME_VALUE = ERROR_PREFIX + "INVALID_ONLINE_GAME_VALUE";

	public static final String UMA_DOES_NOT_EXIST = ERROR_PREFIX + "UMA_DOES_NOT_EXIST";

	public static final String PLAYER_DOES_NOT_EXIST = ERROR_PREFIX + "PLAYER_DOES_NOT_EXIST";

	public static final String RECORD_DOES_NOT_EXIST = ERROR_PREFIX + "PLAYER_RECORD_ON_TOURNAMENT";
	



}
