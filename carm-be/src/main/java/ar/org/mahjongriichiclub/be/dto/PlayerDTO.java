package ar.org.mahjongriichiclub.be.dto;

import java.util.List;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Player;

public class PlayerDTO extends GenericDTO<Player> {
	
	@NotNull
	PersonDTO personDTO;
	
	private List<PlayerAccountDTO> playerAccounts;
	
	@NotBlank
	private String nickname;
	
	@Transient
	private Integer todayRate;
	
	@Transient
	private Integer maxRate;
	
	@Transient
	private Integer minRate;
	
	private List<RateDTO> playerRates;
	
	private List<DanPointsDTO> playerPoints;

	public PersonDTO getPersonDTO() {
		return personDTO;
	}

	public void setPersonDTO(PersonDTO personDTO) {
		this.personDTO = personDTO;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getTodayRate() {
		return todayRate;
	}

	public void setTodayRate(Integer todayRate) {
		this.todayRate = todayRate;
	}

	public Integer getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(Integer maxRate) {
		this.maxRate = maxRate;
	}

	public Integer getMinRate() {
		return minRate;
	}

	public void setMinRate(Integer minRate) {
		this.minRate = minRate;
	}

	public List<RateDTO> getPlayerRates() {
		return playerRates;
	}

	public void setPlayerRates(List<RateDTO> playerRates) {
		this.playerRates = playerRates;
	}

	public List<DanPointsDTO> getPlayerPoints() {
		return playerPoints;
	}

	public void setPlayerPoints(List<DanPointsDTO> playerPoints) {
		this.playerPoints = playerPoints;
	}
	
	

}
