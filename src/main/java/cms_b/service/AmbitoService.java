package cms_b.service;

import java.util.List;

import cms_b.model.Ambito;

public interface AmbitoService {

	List<Ambito> findAllAmbitos();

	Ambito create(Ambito etl);

	Ambito update(Ambito etl);

	Ambito disableAmbito(String keyId);

	List<Ambito> findAmbitos(String[] keyIds);

}
