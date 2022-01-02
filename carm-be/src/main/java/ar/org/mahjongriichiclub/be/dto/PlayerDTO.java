package ar.org.mahjongriichiclub.be.dto;

import java.util.List;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Player;

@MappedEntity(entity = Player.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDTO extends GenericDTO {
	
	@NotNull
	PersonDTO person;
	
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

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
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

	public List<PlayerAccountDTO> getPlayerAccounts() {
		return playerAccounts;
	}

	public void setPlayerAccounts(List<PlayerAccountDTO> playerAccounts) {
		this.playerAccounts = playerAccounts;
	}
	
	

}
