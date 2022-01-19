package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.LocationRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;
import ar.org.mahjongriichiclub.be.request.TournamentResultsRequest;
import ar.org.mahjongriichiclub.be.request.UmaRequest;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.service.CountryService;
import ar.org.mahjongriichiclub.be.service.PersonService;
import ar.org.mahjongriichiclub.be.service.PlayerService;
import ar.org.mahjongriichiclub.be.service.UmaService;
import ar.org.mahjongriichiclub.be.service.LocationService;
import ar.org.mahjongriichiclub.be.service.TResultService;

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

	@Autowired
	LocationService locationService;

	@Autowired
	UmaService umaService;

	@Autowired
	TResultService tResultService;

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
				personDTO = this.getPersonService().findById(person.getId());
			}

			if (personDTO == null) {
				personDTO = new PersonDTO();
			}

			this.fillPersonDTO(person, personDTO);

			personDTO = this.getPersonService().save(personDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_PERSON,
					new String[] { person.getName() + " " + person.getSurnames() }, e);

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

			if (country.getCode() != null) {
				countryDTO = this.getCountryService().findByCode(country.getCode());
			}

			if (countryDTO == null) {
				countryDTO = new CountryDTO();
			}

			countryDTO.setName(country.getName());
			countryDTO.setCode(country.getCode());
			countryDTO.setNationality(country.getNationality());

			countryDTO = this.getCountryService().save(countryDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_COUNTRY, new String[] { country.getName() },
					e);

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

			if (player.getNickname() != null) {
				playerDTO = this.getPlayerService().findByNickname(player.getNickname());
			}

			if (playerDTO == null) {
				playerDTO = new PlayerDTO();
			}

			playerDTO.setNickname(player.getNickname());

			PersonDTO personDTO = null;
			if (player.getPerson() != null) {
				if (player.getPerson().getId() != null) {
					personDTO = this.getPersonService().findById(player.getPerson().getId());
				}

				if (personDTO == null) {
					personDTO = new PersonDTO();
					this.fillPersonDTO(player.getPerson(), personDTO);
				}

				playerDTO.setPerson(personDTO);

			}

			playerDTO = this.getPlayerService().save(playerDTO);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_PLAYER, new String[] { player.getNickname() },
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
		personDTO.setName(person.getName());
		personDTO.setSurnames(person.getSurnames());
		personDTO.setCountry(countryDTO);
		personDTO.setBirthday(person.getBirthday());

	}

	@Override
	public LocationDTO addModifyLocation(LocationRequest location) throws ServiceException {
		LocationDTO locationDTO = null;

		try {

			locationDTO = this.getLocationService().findByName(location.getName());

			if (locationDTO == null) {
				locationDTO = new LocationDTO();
			}

			locationDTO.setName(location.getName());
			locationDTO.setAddress(location.getAddress());
			if (location.getOnlineGame() != null) {
				locationDTO.setOnlineGame(OnlineGame.getEnum(location.getOnlineGame()));
			}


			locationDTO = this.getLocationService().save(locationDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw new ServiceException(ServiceExceptionConstants.INVALID_ONLINE_GAME_VALUE,
					new String[] { location.getOnlineGame() }, e);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_LOCATION, new String[] { location.getName() },
					e);
		}

		return locationDTO;
	}

	/**
	 * Llama al servicio que guarda el uma
	 * 
	 * @param uma
	 * @return umaDTO
	 * 
	 */
	@Override
	public UmaDTO addModifyUma(UmaRequest uma) throws ServiceException {

		UmaDTO umaDTO = null;
		try {

			if (uma.getName() != null) {
				umaDTO = this.getUmaService().findByName(uma.getName());
			}

			if (umaDTO == null) {
				umaDTO = new UmaDTO();
			}

			umaDTO.setName(uma.getName());
			umaDTO.setFirstPlace(uma.getFirstPlace());
			umaDTO.setSecondPlace(uma.getSecondPlace());
			umaDTO.setThirdPlace(uma.getThirdPlace());
			umaDTO.setFourthPlace(uma.getFourthPlace());

			umaDTO = this.getUmaService().save(umaDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_UMA, new String[] { uma.getName() }, e);

		}

		return umaDTO;
	}

	@Override
	public TournamentResultsDTO addModifyTourneyResult(TournamentResultsRequest result) throws ServiceException {
		TournamentResultsDTO tournamentResultDTO = null;
		PlayerDTO playerDTO = null;

		try {

			if (result.getPlayer() != null && result.getName() != null && result.getSeasonName() != null) {
				tournamentResultDTO = this.getTResultService().findByPlayerAndTournamentAndSeason(result.getPlayer(), result.getName(), result.getSeasonName());
			}

			if (tournamentResultDTO == null) {
				tournamentResultDTO = new TournamentResultsDTO();
				
				playerDTO = this.getPlayerService().findByNickname(result.getPlayer());	
				tournamentResultDTO.setPlayer(playerDTO);
			}

			tournamentResultDTO.setPoints(result.getPoints());
			tournamentResultDTO.setFinalPlacement(result.getFinalPlacement());

			tournamentResultDTO = this.getTResultService().save(tournamentResultDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_TOURNEY_RESULT,
					new String[] { result.getPlayer() }, e);

		}
		return null;
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

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public UmaService getUmaService() {
		return umaService;
	}

	public void setUmaService(UmaService umaService) {
		this.umaService = umaService;
	}

	public TResultService getTResultService() {
		return tResultService;
	}

	public void setTResultService(TResultService tResultService) {
		this.tResultService = tResultService;
	}

}
