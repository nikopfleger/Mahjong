package ar.org.mahjongriichiclub.be.generic.model;

import java.util.Date;

public interface EntityObject {

	public Long getId();

	public void setId(Long oid);

	public Boolean getDeleted();

	public void setDeleted(Boolean deleted);

	public String getCreatedBy();

	public void setCreatedBy(String createdBy);

	public Date getCreated();

	public void setCreated(Date crated);

	public String getUpdatedBy();

	public void setUpdatedBy(String updatedBy);

	public Date getUpdated();

	public void setUpdated(Date updated);

}
