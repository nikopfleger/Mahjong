package ar.org.mahjongriichiclub.be.generic.dto;

import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public class GenericDTO<ENTITY extends AbstractEntity>{
	
	private Long id;

	private Boolean deleted = false;
	
	public static final String DATE_PATTERN = "dd/MM/yyyy";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
