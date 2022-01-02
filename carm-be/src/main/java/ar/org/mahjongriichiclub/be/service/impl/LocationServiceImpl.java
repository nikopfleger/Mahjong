package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Location;
import ar.org.mahjongriichiclub.be.service.LocationService;


@Service("locationServiceImpl")
public class LocationServiceImpl extends GenericServiceImpl<Location, LocationDTO> implements LocationService {


}
