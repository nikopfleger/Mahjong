package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.entity.Season;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;

@MappedEntity(entity = Season.class)
public class SeasonDTO extends GenericDTO {

	private Integer number;

	private String name;

	@DateTimeFormat(pattern = GenericDTO.DATE_PATTERN)
	@JsonFormat(pattern = GenericDTO.DATE_PATTERN)
	private Date startDate;

	@DateTimeFormat(pattern = GenericDTO.DATE_PATTERN)
	@JsonFormat(pattern = GenericDTO.DATE_PATTERN)
	private Date endDate;

	private Boolean rankedGamesCount;

	private RulesetDTO ruleset;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getRankedGamesCount() {
		return rankedGamesCount;
	}

	public void setRankedGamesCount(Boolean rankedGamesCount) {
		this.rankedGamesCount = rankedGamesCount;
	}

	public RulesetDTO getRuleset() {
		return ruleset;
	}

	public void setRuleset(RulesetDTO ruleset) {
		this.ruleset = ruleset;
	}

}
