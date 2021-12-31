package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PlayerResponse;
import ar.org.mahjongriichiclub.be.model.Country;
import ar.org.mahjongriichiclub.be.model.Person;
import ar.org.mahjongriichiclub.be.model.Player;
import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.service.CountryService;
import ar.org.mahjongriichiclub.be.service.PersonService;
import ar.org.mahjongriichiclub.be.service.PlayerService;

/**
 * @author Niko
 *
 */
@Service(value = "backofficeService")
public class BackofficeServiceImpl implements BackofficeService {

	@Autowired
	PersonService personService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired	
	PlayerService playerService;

	/**
	 * Llama al servicio que guarda la persona
	 * 
	 * @param person
	 * @return ResponseEntity
	 * 
	 */
	@Override
	public ResponseEntity<PersonResponse> addModifyPerson(PersonRequest person) throws ServiceException {
		PersonResponse personResponse = new PersonResponse();
		try {		
			
			PersonDTO personDTO = this.getPersonService().findById(person.getId(), PersonDTO.class, Person.class);
			
			if (personDTO == null) {
				personDTO = new PersonDTO();
			}
			
			this.fillPersonDTO(person, personDTO);
			
			PersonDTO savedPersonDTO = this.getPersonService().save(personDTO);
			this.fillPersonResponse(personResponse, savedPersonDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_USER,
					new String[] { person.getNames() + " " + person.getSurnames() }, e);

		}

		return new ResponseEntity<PersonResponse>(personResponse, HttpStatus.CREATED);
	}

	/**
	 * Llena los campos de la persona para la respuesta
	 * 
	 * @param personResponse
	 * @param person
	 */
	protected void fillPersonResponse(PersonResponse personResponse, PersonDTO person) {
		CountryResponse countryResponse = new CountryResponse();
		CountryDTO countryPerson = person.getCountry();

		countryResponse.setName(countryPerson.getName());
		countryResponse.setCode(countryPerson.getCode());
		countryResponse.setNationality(countryPerson.getNationality());

		personResponse.setNames(person.getNames());
		personResponse.setSurnames(person.getSurnames());
		personResponse.setBirthday(person.getBirthday());
		personResponse.setCountry(countryResponse);

	}

	/**
	 * Llama al servicio que guarda el país
	 * 
	 * @param country
	 * @return ResponseEntity
	 * 
	 */
	@Override
	public ResponseEntity<CountryResponse> addModifyCountry(CountryRequest country) {
		CountryResponse countryResponse = new CountryResponse();
		try {

			CountryDTO countryDTO = this.getCountryService().findById(country.getId(), CountryDTO.class, Country.class);
			
			if (countryDTO == null) {
				countryDTO = new CountryDTO();
			}
			
			countryDTO.setName(country.getName());
			countryDTO.setCode(country.getCode());
			countryDTO.setNationality(country.getNationality());
			
			CountryDTO savedCountryDTO = this.getCountryService().save(countryDTO);
			
			countryResponse.setName(savedCountryDTO.getName());
			countryResponse.setCode(savedCountryDTO.getCode());
			countryResponse.setNationality(savedCountryDTO.getNationality());
			
		} catch (ServiceException e) {
			throw(e);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_COUNTRY,
					new String[] { country.getName() }, e);

		}

		return new ResponseEntity<CountryResponse>(countryResponse, HttpStatus.CREATED);
	}
	
	/**
	 * Llama al servicio que guarda el jugador
	 * 
	 * @param player
	 * @return ResponseEntity
	 * 
	 */
	@Override
	public ResponseEntity<PlayerResponse> addModifyPlayer(PlayerRequest player) throws ServiceException {
		PlayerResponse playerResponse = new PlayerResponse();
		
		try {
			
			PlayerDTO playerDTO = this.getPlayerService().findById(player.getId(), PlayerDTO.class, Player.class);
			
			if (playerDTO == null) {
				playerDTO = new PlayerDTO();
			}
			
			playerDTO.setNickname(player.getNickname());			

			
			if (player.getPerson()  != null) {
				
				PersonDTO personDTO = new PersonDTO();				
				this.fillPersonDTO(player.getPerson(), personDTO);
				playerDTO.setPersonDTO(personDTO);
				
			}
			
			PlayerDTO savedPlayerDTO = this.getPlayerService().save(playerDTO);
			
			PersonResponse personResponse = new PersonResponse();
			
			this.fillPersonResponse(personResponse, savedPlayerDTO.getPersonDTO());
			
			playerResponse.setPerson(personResponse);
			playerResponse.setNickname(savedPlayerDTO.getNickname());
			
		} catch (ServiceException e) {
			throw(e);
		}
		catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_PLAYER, new String[] { player.getNickname() });
		}
		return new ResponseEntity<PlayerResponse>(playerResponse, HttpStatus.CREATED);
	}
	
	
	/**
	 * Llena la personaDTO
	 * @param person
	 * @param personDTO
	 */
	protected void fillPersonDTO(PersonRequest person, PersonDTO personDTO) throws ServiceException {
		
		CountryDTO countryDTO = this.getCountryService().findByCode(person.getCountryCode());		
		personDTO.setNames(person.getNames());
		personDTO.setSurnames(person.getSurnames());
		personDTO.setCountry(countryDTO);
		personDTO.setBirthday(person.getBirthday());
		
	}


	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

}
