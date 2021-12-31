package ar.org.mahjongriichiclub.be.dto;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.PointsDTO;
import ar.org.mahjongriichiclub.be.model.Rate;

@MappedEntity(entity = Rate.class)
public class RateDTO extends PointsDTO<Rate> {

}
