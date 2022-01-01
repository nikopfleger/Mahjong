package ar.org.mahjongriichiclub.be;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarmBeApplication {
	


	public static void main(String[] args) {
		Logger logger = LogManager.getRootLogger();
    	logger.trace("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));
    	SpringApplication.run(CarmBeApplication.class, args);   	

	}

}
