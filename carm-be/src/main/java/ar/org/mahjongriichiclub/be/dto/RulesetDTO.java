package ar.org.mahjongriichiclub.be.dto;

import ar.org.mahjongriichiclub.be.enumerations.GameLength;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Ruleset;

public class RulesetDTO extends GenericDTO<Ruleset> {

	private UmaDTO uma;

	private Integer oka;
	
	private Integer chonbo;
	
	private GameLength gameType;
	
	private Boolean aka;
	
	private Integer inPoints;
	
	private Integer outPoints;
	
	private Boolean suddenDeath;
	
	private Boolean sanma;
	
	private Boolean rounding;

	public UmaDTO getUma() {
		return uma;
	}

	public void setUma(UmaDTO uma) {
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
	
	
}
