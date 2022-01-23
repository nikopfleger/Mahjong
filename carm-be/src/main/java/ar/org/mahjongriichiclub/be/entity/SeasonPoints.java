package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.entity.Points;

@Entity
@Table(name = "SEASON_POINTS")
@SQLDelete(sql = "UPDATE SEASON_POINTS SET deleted = 1 WHERE id=?")
public class SeasonPoints extends Points {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7229517271028049293L;

}
