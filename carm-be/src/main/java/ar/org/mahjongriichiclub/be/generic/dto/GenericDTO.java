package ar.org.mahjongriichiclub.be.generic.dto;





public class GenericDTO {
	
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
