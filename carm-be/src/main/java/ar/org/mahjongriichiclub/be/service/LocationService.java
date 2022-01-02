package ar.org.mahjongriichiclub.be.service;

import javax.persistence.NonUniqueResultException;

import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.Location;

public interface LocationService extends GenericService<Location,LocationDTO> {

	public LocationDTO findByName(String name);

	public LocationDTO findOneByIdOrName(Long id, String name) throws NonUniqueResultException;

}
