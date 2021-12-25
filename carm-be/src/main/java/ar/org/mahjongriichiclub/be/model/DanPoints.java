package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.Points;


@Entity
@Table(name = "DAN_POINTS")
@SQLDelete(sql = "UPDATE GAME SET deleted = 1 WHERE id=?")
public class DanPoints extends Points {
	

	
}
