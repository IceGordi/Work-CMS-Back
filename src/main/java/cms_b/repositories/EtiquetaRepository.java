package cms_b.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.query.Param;

import cms_b.model.Etiqueta;




public interface EtiquetaRepository extends CouchbaseRepository<Etiqueta,String>,EtiquetaRepositoryCustom{
	
	//random N1QL Queries
	
	@Query("#{#n1ql.selectEntity} WHERE  type = 'etiqueta'")
	List<Etiqueta> findAllEtiquetas();
	
	@Query("#{#n1ql.selectEntity} WHERE type = 'etiqueta' AND  keyId = $keyId")
	List<Etiqueta> findByKeyId(@Param("keyId")String keyId);
	
	@Query("#{#n1ql.selectEntity} WHERE type = 'etiqueta' AND id = $id")
	List<Etiqueta> findById1(@Param("id")String id);
	
	@Query("#{#n1ql.selectEntity} WHERE type = 'etiqueta' AND docId = $docId")
	Etiqueta findByDocId(@Param("docId")String docId);
	@Query("DELETE FROM etiquetasBucket WHERE type = 'etiqueta' AND keyId = $keyId")
	List<Etiqueta> deleteByKeyId(String keyId);
	@Query("UPDATE etiquetasBucket SET available = false WHERE keyId = $keyId AND type = 'etiqueta'")
	List<Etiqueta> disableEtiqueta(String keyId);
}
