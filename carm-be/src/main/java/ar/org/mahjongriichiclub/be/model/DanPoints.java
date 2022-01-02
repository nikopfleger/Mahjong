package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.Points;


@Entity
@Table(name = "DAN_POINTS")
@SQLDelete(sql = "UPDATE DAN_POINTS SET deleted = 1 WHERE id=?")
public class DanPoints extends Points {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731544160346081383L;
	

	
}
