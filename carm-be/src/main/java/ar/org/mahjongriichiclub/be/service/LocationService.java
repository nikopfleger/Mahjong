package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.entity.Location;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;

public interface LocationService extends GenericService<Location,LocationDTO> {

	@Transactional(readOnly = true)
	public LocationDTO findOneByIdAndName(Long id, String name);
	
	@Transactional(readOnly = true)
	public LocationDTO findByName(String name);

}
