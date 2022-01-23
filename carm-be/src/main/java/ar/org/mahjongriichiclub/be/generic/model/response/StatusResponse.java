package ar.org.mahjongriichiclub.be.generic.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusResponse<D extends GenericDTO> {

	public static final String CREATED = "CREATED";

	private String status;
	@JsonProperty("object")
	private D dto;
	private List<ApiError> errors = null;

	public StatusResponse(String status) {
		this.status = status;
	}

	public StatusResponse(D dto, String status) {
		this.setDto(dto);
		this.status = status;
	}

	public StatusResponse(String status, List<ApiError> errors) {
		this.status = status;
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<ApiError> errors) {
		this.errors = errors;
	}

	public D getDto() {
		return dto;
	}

	public void setDto(D dto) {
		this.dto = dto;
	}

}
