package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.dto.SeasonPointsDTO;
import ar.org.mahjongriichiclub.be.generic.model.Points;

@Entity
@Table(name = "SEASON_POINTS")
@SQLDelete(sql = "UPDATE SEASON_POINTS SET deleted = 1 WHERE id=?")
@MappedDTO(dto = SeasonPointsDTO.class)
public class SeasonPoints extends Points {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7229517271028049293L;

}
