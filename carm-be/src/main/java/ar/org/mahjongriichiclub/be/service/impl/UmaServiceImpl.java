package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.UmaDAO;
import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Uma;
import ar.org.mahjongriichiclub.be.service.UmaService;

@Service("umaServiceImpl")
public class UmaServiceImpl extends GenericServiceImpl<Uma, UmaDTO> implements UmaService {

	@Autowired
	UmaDAO umaDAO;
	
	@Override
	public UmaDTO findOneByIdAndName(Long id, String name) {
		Uma uma = null;
		uma = this.getUmaDAO().findOneByIdAndName(id,name);
		
		if (uma == null) {
			throw new ServiceException(ServiceExceptionConstants.ID_NAME_MUST_BE_UNIQUE_AND_MATCH);
		}		

		return this.toDTO(uma);
	}

	@Override
	public UmaDTO findByName(String name) {

		Uma uma = this.getUmaDAO().findByName(name);

		return uma != null ? this.toDTO(uma) : null;
	}

	public UmaDAO getUmaDAO() {
		return umaDAO;
	}

	public void setUmaDAO(UmaDAO umaDAO) {
		this.umaDAO = umaDAO;
	}

}
