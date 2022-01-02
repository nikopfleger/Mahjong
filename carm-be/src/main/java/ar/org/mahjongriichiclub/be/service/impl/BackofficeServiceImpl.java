package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
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
	 * @return PersonDTO
	 * 
	 */
	@Override
	public PersonDTO addModifyPerson(PersonRequest person) throws ServiceException {

		PersonDTO personDTO = null;
		try {
			

			if (person.getId() != null) {
				personDTO = this.getPersonService().findById(Person.class, person.getId());
			}

			if (personDTO == null) {
				personDTO = new PersonDTO();
			}

			this.fillPersonDTO(person, personDTO);

			this.getPersonService().save(personDTO);

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_USER,
					new String[] { person.getNames() + " " + person.getSurnames() }, e);

		}

		return personDTO;
	}


	/**
	 * Llama al servicio que guarda el país
	 * 
	 * @param country
	 * @return CountryDTO
	 * 
	 */
	@Override
	public CountryDTO addModifyCountry(CountryRequest country) {
		
		CountryDTO countryDTO = null;
		try {
			

			if (country.getId() != null) {
				countryDTO = this.getCountryService().findById(Country.class, country.getId());
			}

			if (countryDTO == null) {
				countryDTO = new CountryDTO();
			}

			countryDTO.setName(country.getName());
			countryDTO.setCode(country.getCode());
			countryDTO.setNationality(country.getNationality());

			this.getCountryService().save(countryDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_COUNTRY, new String[] { country.getName() }, e);

		}

		return countryDTO;
	}

	/**
	 * Llama al servicio que guarda el jugador
	 * 
	 * @param player
	 * @return PlayerDTO
	 * 
	 */
	@Override
	public PlayerDTO addModifyPlayer(PlayerRequest player) {

		PlayerDTO playerDTO = null;
		try {
			

			if (player.getId() != null) {
				playerDTO = this.getPlayerService().findById(Player.class, player.getId());
			}

			if (playerDTO == null) {
				playerDTO = new PlayerDTO();
			}

			playerDTO.setNickname(player.getNickname());

			PersonDTO personDTO = null;
			if (player.getPerson() != null) {
				if (player.getPerson().getId() != null) {
					personDTO = this.getPersonService().findById(Person.class, player.getPerson().getId());
				}

				if (personDTO == null) {
					personDTO = new PersonDTO();
					this.fillPersonDTO(player.getPerson(), personDTO);
				}

				playerDTO.setPerson(personDTO);

			}

			this.getPlayerService().save(playerDTO);


		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_PLAYER, new String[] { player.getNickname() },
					e);
		}
		return playerDTO;
	}

	/**
	 * Llena la personaDTO
	 * 
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
