package ar.org.mahjongriichiclub.be.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.TournamentType;
import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

@Entity
@Table(name = "TOURNAMENT")
@SQLDelete(sql = "UPDATE SEASON SET deleted = 1 WHERE id=?")
public class Tournament extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5554365457117766193L;
	
	@Column(name = "name")
	private String name;

	@Column(name= "tournamentType")
	@Enumerated(EnumType.STRING)
	private TournamentType tournamentType;
	
	@Column(name="startDate")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="endDate")
	@Temporal(TemporalType.DATE)
	private Date endDate;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOURNAMENT_ID", foreignKey = @ForeignKey(name = "TOURNAMENT_SEASON_FK"))
	private Season season;	

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOURNAMENT_ID", foreignKey = @ForeignKey(name = "TOURNAMENT_RESULTS_FK"))
	private List<TournamentResults> results;

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

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public List<TournamentResults> getResults() {
		return results;
	}

	public void setResults(List<TournamentResults> results) {
		this.results = results;
	}

	public TournamentType getTournamentType() {
		return tournamentType;
	}

	public void setTournamentType(TournamentType tournamentType) {
		this.tournamentType = tournamentType;
	}
	
	
}
