package cms_b.service;


import java.util.List;

import cms_b.model.Etiqueta;

public interface EtiquetaService {
//random methods

	//List<Etiqueta> delete(String id);

	List<Etiqueta> delete(String id);
	
	List<Etiqueta> findAllEtiquetas();

	List<Etiqueta> findAllAmbitos();

	Etiqueta update(Etiqueta etiqueta);

	Etiqueta create(Etiqueta et);

	List<Etiqueta> findById(String id);

	List<Etiqueta> findByKeyId(String keyId);

	Etiqueta findByDocId(String docId);

	List<Etiqueta> findByAmbitos(List<String> ambitoList);
	
	
}
