package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.LocationDAO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.entity.Location;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.service.LocationService;


@Service("locationServiceImpl")
public class LocationServiceImpl extends GenericServiceImpl<Location, LocationDTO> implements LocationService {

	@Autowired
	private LocationDAO locationDao;


	@Override
	public LocationDTO findOneByIdAndName(Long id, String name) throws ServiceException {
		Location location = null;
		location = this.getLocationDAO().findOneByIdAndName(id,name);
		
		if (location == null) {
			throw new ServiceException(ServiceExceptionConstants.UMA_DOES_NOT_EXIST);
		}		

		return this.toDTO(location);
	}	
	
	@Override
	public LocationDTO findByName(String name) {

		Location location = this.getLocationDAO().findByName(name);

		return location != null ? this.toDTO(location) : null;
	}
	
	
	public LocationDAO getLocationDAO() {
		return locationDao;
	}

	public void setLocationDAO(LocationDAO locationDao) {
		this.locationDao = locationDao;
	}



}
