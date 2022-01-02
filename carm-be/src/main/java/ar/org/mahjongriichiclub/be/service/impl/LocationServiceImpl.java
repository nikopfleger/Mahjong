package ar.org.mahjongriichiclub.be.service.impl;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dao.LocationDAO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Location;
import ar.org.mahjongriichiclub.be.service.LocationService;


@Service("locationServiceImpl")
public class LocationServiceImpl extends GenericServiceImpl<Location, LocationDTO> implements LocationService {

	@Autowired
	private LocationDAO locationDao;

	@Override
	public LocationDTO findByName(String name) {

		Location location = this.getLocationDAO().findByName(name);

		return location != null ? this.toDTO(location) : null;
	}
	
	@Override
	public LocationDTO findOneByIdOrName(Long id, String name) throws NonUniqueResultException {

		Location location = this.getLocationDAO().findOneByIdOrName(id,name);

		return location != null ? this.toDTO(location) : null;
	}
	
	
	public LocationDAO getLocationDAO() {
		return locationDao;
	}

	public void setLocationDAO(LocationDAO locationDao) {
		this.locationDao = locationDao;
	}


}
