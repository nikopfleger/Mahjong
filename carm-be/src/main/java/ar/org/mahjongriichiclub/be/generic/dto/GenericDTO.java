package ar.org.mahjongriichiclub.be.generic.dto;

import java.lang.reflect.ParameterizedType;

import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.exception.LocalizedException;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public class GenericDTO<ENTITY extends AbstractEntity>{
	
	@JMap
	private Long id;

	@JMap("deleted")
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
