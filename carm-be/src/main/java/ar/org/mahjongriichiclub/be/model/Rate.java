package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.Points;


@Entity
@Table(name = "RATE")
@SQLDelete(sql = "UPDATE RATE SET deleted = 1 WHERE id=?")
public class Rate extends Points {


	
}
