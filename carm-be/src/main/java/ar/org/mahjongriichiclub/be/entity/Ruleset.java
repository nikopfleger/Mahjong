package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.GameLength;
import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

@Entity
@Table(name = "RULESET")
@SQLDelete(sql = "UPDATE RULESET SET deleted = 1 WHERE id=?")
public class Ruleset extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 679781809336256419L;
	
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UMA_ID", foreignKey = @ForeignKey(name = "RULESET_UMA_FK"))
	private Uma uma;

	@Column(name="OKA")
	private Integer oka;
	
	@Column(name="CHONBO")
	private Integer chonbo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GAME_TYPE", nullable= false)
	private GameLength gameType;
	
	@Column(name="AKA", nullable= false)
	private Boolean aka;
	
	@Column(name="IN_POINTS", nullable= false)
	private Integer inPoints;
	
	@Column(name="OUT_POINTS", nullable= false)
	private Integer outPoints;
	
	@Column(name="SUDDEN_DEATH", nullable= false)
	private Boolean suddenDeath;
	
	@Column(name="SANMA", nullable= false)
	private Boolean sanma;
	
	@Column(name="ROUNDING", nullable = false)
	private Boolean rounding;

	public Uma getUma() {
		return uma;
	}

	public void setUma(Uma uma) {
		this.uma = uma;
	}

	public Integer getOka() {
		return oka;
	}

	public void setOka(Integer oka) {
		this.oka = oka;
	}

	public Integer getChonbo() {
		return chonbo;
	}

	public void setChonbo(Integer chonbo) {
		this.chonbo = chonbo;
	}

	public GameLength getGameType() {
		return gameType;
	}

	public void setGameType(GameLength gameType) {
		this.gameType = gameType;
	}

	public Boolean getAka() {
		return aka;
	}

	public void setAka(Boolean aka) {
		this.aka = aka;
	}

	public Integer getInPoints() {
		return inPoints;
	}

	public void setInPoints(Integer inPoints) {
		this.inPoints = inPoints;
	}

	public Integer getOutPoints() {
		return outPoints;
	}

	public void setOutPoints(Integer outPoints) {
		this.outPoints = outPoints;
	}

	public Boolean getSuddenDeath() {
		return suddenDeath;
	}

	public void setSuddenDeath(Boolean suddenDeath) {
		this.suddenDeath = suddenDeath;
	}

	public Boolean getSanma() {
		return sanma;
	}

	public void setSanma(Boolean sanma) {
		this.sanma = sanma;
	}

	public Boolean getRounding() {
		return rounding;
	}

	public void setRounding(Boolean rounding) {
		this.rounding = rounding;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
