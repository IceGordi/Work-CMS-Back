package cms_b.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms_b.exception.APIException;
import cms_b.exception.ErrorType;
import cms_b.model.Ambito;
import cms_b.repositories.AmbitoRepository;

@Service
public class AmbitoServiceImpl implements AmbitoService{

	
	@Autowired
	AmbitoRepository ambrepo;

	@Override
	public List<Ambito> findAllAmbitos() {
		return ambrepo.findAllAmbitos();
	}

	@Override
	public Ambito create(Ambito amb) {
		Optional<Ambito> a = ambrepo.findById(amb.getDocId());
		if(a.isPresent()) {
			throw new APIException(ErrorType.ETIQUETA_YA_EXISTE);
		}else {
			return ambrepo.save(amb);
		}
	}

	@Override
	public Ambito update(Ambito etl) {
		etl.setModified(new Date());
		Optional<Ambito> a = ambrepo.findById(etl.getDocId());
		if(!a.isPresent()) {
			throw new APIException(ErrorType.ETIQUETA_NOT_FOUND);
		}else {
			return ambrepo.save(etl);
		}
	}

	@Override
	public List<Ambito> findAmbitos(String[] keyIds) {
		// TODO Auto-generated method stub
		List<Ambito> list = new ArrayList<Ambito>();
		for(String key:keyIds) {
			list.add(ambrepo.findByKeyId(key));
		}
		return list;
	
	}
	
	
	public Ambito delete(String keyId) {
		return ambrepo.deleteByKeyId(keyId);
	}
}
