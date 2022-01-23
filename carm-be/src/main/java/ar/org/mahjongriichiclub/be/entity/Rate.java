package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.entity.Points;


@Entity
@Table(name = "RATE")
@SQLDelete(sql = "UPDATE RATE SET deleted = 1 WHERE id=?")
public class Rate extends Points {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8611965400925782249L;


	
}
