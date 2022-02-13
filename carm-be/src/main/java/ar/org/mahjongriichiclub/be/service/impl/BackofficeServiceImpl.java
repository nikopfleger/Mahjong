package ar.org.mahjongriichiclub.be.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerAccountDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.dto.SeasonDTO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.enumerations.GameLength;
import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.model.CountryModel;
import ar.org.mahjongriichiclub.be.model.LocationModel;
import ar.org.mahjongriichiclub.be.model.PersonModel;
import ar.org.mahjongriichiclub.be.model.PlayerModel;
import ar.org.mahjongriichiclub.be.model.RulesetModel;
import ar.org.mahjongriichiclub.be.model.SeasonModel;
import ar.org.mahjongriichiclub.be.model.TournamentResultsModel;
import ar.org.mahjongriichiclub.be.model.UmaModel;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.service.CountryService;
import ar.org.mahjongriichiclub.be.service.PersonService;
import ar.org.mahjongriichiclub.be.service.PlayerService;
import ar.org.mahjongriichiclub.be.service.UmaService;
import ar.org.mahjongriichiclub.be.service.LocationService;
import ar.org.mahjongriichiclub.be.service.TResultService;
import ar.org.mahjongriichiclub.be.service.SeasonService;
import ar.org.mahjongriichiclub.be.service.RulesetService;

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

	@Autowired
	SeasonService seasonService;

	@Autowired
	RulesetService rulesetService;

	/**
	 * Llama al servicio que guarda la persona
	 * 
	 * @param person
	 * @return PersonDTO
	 * 
	 */
	@Override
	public PersonDTO addModifyPerson(PersonModel person) throws ServiceException {

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
	public CountryDTO addModifyCountry(CountryModel country) {

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
	public PlayerDTO addModifyPlayer(PlayerModel player) {

		String onlineIDValue = null;
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
					
					if (personDTO == null) {
						throw new ServiceException(ServiceExceptionConstants.PERSON_DOES_NOT_EXIST, new String[] { player.getPerson().getName() });
					}
				}

				if (personDTO == null) {
					personDTO = new PersonDTO();
					this.fillPersonDTO(player.getPerson(), personDTO);
				}

				if (player.getOnlineAccounts() != null && player.getOnlineAccounts().size() > 0) {

					List<PlayerAccountDTO> accounts = new ArrayList<>();

					for (Map.Entry<String, String> onlineID : player.getOnlineAccounts().entrySet()) {

						PlayerAccountDTO playerAccount = new PlayerAccountDTO();

						playerAccount.setAccountId(onlineID.getKey());

						onlineIDValue = onlineID.getValue().toUpperCase();
						OnlineGame onlineGame = OnlineGame.valueOf(onlineIDValue);
						playerAccount.setGameAccount(onlineGame);

						accounts.add(playerAccount);
					}

					playerDTO.setPlayerAccounts(accounts);
				}

				playerDTO.setPerson(personDTO);

			}

			playerDTO = this.getPlayerService().save(playerDTO);
		} catch (ServiceException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw new ServiceException(ServiceExceptionConstants.ONLINE_GAME_DOES_NOT_EXIST,
					new String[] { onlineIDValue }, e);
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
	protected void fillPersonDTO(PersonModel person, PersonDTO personDTO) throws ServiceException {

		personDTO.setName(person.getName());
		personDTO.setSurnames(person.getSurnames());
		personDTO.setBirthday(person.getBirthday());

		if (personDTO.getCountry() == null) {
			CountryDTO country = this.countryService.findByCode(person.getCountryCode());
			if (country == null) {
				throw new ServiceException(ServiceExceptionConstants.COUNTRY_DOES_NOT_EXIST,
						new String[] { person.getCountryCode() });
			}
			personDTO.setCountry(country);
		}

	}

	@Override
	public LocationDTO addModifyLocation(LocationModel location) throws ServiceException {
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
	public UmaDTO addModifyUma(UmaModel uma) throws ServiceException {

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
	public TournamentResultsDTO addModifyTourneyResult(TournamentResultsModel result) throws ServiceException {
		TournamentResultsDTO tournamentResultDTO = null;
		PlayerDTO playerDTO = null;

		try {

			if (result.getPlayer() != null && result.getName() != null && result.getSeasonName() != null) {
				tournamentResultDTO = this.getTResultService().findByPlayerAndTournamentAndSeason(result.getPlayer(),
						result.getName(), result.getSeasonName());
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
		return tournamentResultDTO;
	}

	@Override
	public SeasonDTO addModifySeason(SeasonModel season) {
		SeasonDTO seasonDTO = null;

		try {
			if (season.getNumber() != null) {
				seasonDTO = this.getSeasonService().findByNumber(season.getNumber());
			}

			if (seasonDTO == null) {
				seasonDTO = new SeasonDTO();
			}

			seasonDTO.setName(season.getName());
			seasonDTO.setNumber(season.getNumber());
			seasonDTO.setStartDate(season.getStartDate());
			seasonDTO.setEndDate(season.getEndDate());
			if (season.getRankedGamesCount() != null) {
				seasonDTO.setRankedGamesCount(season.getRankedGamesCount());
			} else {
				seasonDTO.setRankedGamesCount(Boolean.FALSE);
			}

			RulesetDTO rulesetDTO = this.getRulesetService().findByName(season.getRuleset());

			seasonDTO.setRuleset(rulesetDTO);

			seasonDTO = this.getSeasonService().save(seasonDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_SEASON,
					new String[] { season.getNumber().toString() }, e);
		}
		return seasonDTO;
	}

	@Override
	public RulesetDTO addModifyRuleset(RulesetModel ruleset) throws ServiceException {

		RulesetDTO rulesetDTO = null;

		try {
			rulesetDTO = this.getRulesetService().findByName(ruleset.getName());

			if (rulesetDTO == null) {
				rulesetDTO = new RulesetDTO();
			}

			this.getRulesetService().findAll(ruleset);

			fillRulesetDTO(ruleset, rulesetDTO);

			rulesetDTO = this.getRulesetService().save(rulesetDTO);

		} catch (ServiceException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw new ServiceException(ServiceExceptionConstants.INVALID_GAME_LENGTH_NAME,
					new String[] { ruleset.getGameLength() }, e);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATING_RULESET, new String[] { ruleset.getName() },
					e);
		}

		return rulesetDTO;
	}

	private void fillRulesetDTO(RulesetModel ruleset, RulesetDTO rulesetDTO) throws IllegalArgumentException {

		UmaDTO umaDTO = this.getUmaService().findByName(ruleset.getUma());

		if (umaDTO == null) {
			throw new ServiceException(ServiceExceptionConstants.UMA_DOES_NOT_EXIST, new String[] { ruleset.getUma() });
		}

		rulesetDTO.setName(ruleset.getName());

		rulesetDTO.setUma(umaDTO);
		rulesetDTO.setAka(ruleset.getAka() != null ? ruleset.getAka() : Boolean.FALSE);
		rulesetDTO.setChonbo(ruleset.getChonbo() != null ? ruleset.getChonbo() : 0);

		GameLength gameLength = GameLength.valueOf(ruleset.getGameLength().toUpperCase());

		rulesetDTO.setGameLength(gameLength);
		rulesetDTO.setInPoints(ruleset.getInPoints());
		rulesetDTO.setOutPoints(ruleset.getOutPoints() != null ? ruleset.getOutPoints() : ruleset.getInPoints());
		rulesetDTO.setOka(ruleset.getOka() != null ? ruleset.getOka() : 0);
		rulesetDTO.setRounding(ruleset.getRounding() != null ? ruleset.getRounding() : Boolean.FALSE);
		rulesetDTO.setSanma(ruleset.getSanma() != null ? ruleset.getSanma() : Boolean.FALSE);
		rulesetDTO.setSuddenDeath(ruleset.getSuddenDeath() != null ? ruleset.getSuddenDeath() : Boolean.FALSE);

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

	public TResultService gettResultService() {
		return tResultService;
	}

	public void settResultService(TResultService tResultService) {
		this.tResultService = tResultService;
	}

	public SeasonService getSeasonService() {
		return seasonService;
	}

	public void setSeasonService(SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	public RulesetService getRulesetService() {
		return rulesetService;
	}

	public void setRulesetService(RulesetService rulesetService) {
		this.rulesetService = rulesetService;
	}

}
