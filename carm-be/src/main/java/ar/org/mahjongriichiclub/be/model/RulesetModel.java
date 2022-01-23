package ar.org.mahjongriichiclub.be.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RulesetModel {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String uma;

	private Integer oka;

	private Integer chonbo;

	@NotBlank
	private String gameLength;

	private Boolean aka;

	@NotNull
	private Integer inPoints;

	private Integer outPoints;

	private Boolean suddenDeath;

	private Boolean sanma;

	private Boolean rounding;

	public String getUma() {
		return uma;
	}

	public void setUma(String uma) {
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

	public String getGameLength() {
		return gameLength;
	}

	public void setGameLength(String gameLength) {
		this.gameLength = gameLength;
	}

}
