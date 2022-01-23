package ar.org.mahjongriichiclub.be.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

@Entity
@Table(name = "SEASON")
@SQLDelete(sql = "UPDATE SEASON SET deleted = 1 WHERE id=?")
public class Season extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -842700794019813783L;

	@Column(name = "SEASON_NUMBER", nullable = false)
	private Integer number;

	@Column(name = "SEASON_NAME")
	private String name;

	@Column(name = "START_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	@Column(name = "RANKED_GAMES_COUNT", nullable = false)
	private Boolean rankedGamesCount;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "RULESET_ID", foreignKey = @ForeignKey(name = "SEASON_RULESET_FK"))
	private Ruleset ruleset;

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

	public Ruleset getRuleset() {
		return ruleset;
	}

	public void setRuleset(Ruleset ruleset) {
		this.ruleset = ruleset;
	}

}
