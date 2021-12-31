package ar.org.mahjongriichiclub.be.dto;

import java.util.List;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Player;

@MappedEntity(entity = Player.class)
public class PlayerDTO extends GenericDTO<Player> {
	
	@NotNull
	PersonDTO person;
	
	private List<PlayerAccountDTO> playerAccounts;
	
	@NotBlank
	@JMap("nickname")
	private String nickname;
	
	@Transient
	private Integer todayRate;
	
	@Transient
	private Integer maxRate;
	
	@Transient
	private Integer minRate;
	
	@JMap("playerRates")
	private List<RateDTO> playerRates;
	
	@JMap("playerPoints")
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
