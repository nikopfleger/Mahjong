package ar.org.mahjongriichiclub.be.generic.entity;

import java.io.Serializable;
import java.lang.StackWalker.Option;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class AbstractEntity implements EntityObject, Serializable {

	@Transient
	protected final Logger logger = LogManager.getLogger(getClass());

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "VERSION", nullable = false)
	@Version
	private Integer version;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "CREATED", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date created;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date updated;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (this.getId() == null) {
			return false;
		} else if (!this.getId().equals(other.getId()))
			return false;

		return true;
	}

	public AbstractEntity() {
		super();
	}

	@PrePersist
	public void prePersist() {
		Class<?> clazz = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass();

		logger.info("Attempting to add new entity " + clazz.toString());
		this.setCreated(new Date());
		this.setCreatedBy("ADMIN");
	}

	@PreUpdate
	public void preUpdate() {
		Class<?> clazz = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass();

		logger.info("Attempting to update id " + this.getId() + " of entity " + clazz.toString());
		this.setUpdated(new Date());
		this.setUpdatedBy("ADMIN");
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
