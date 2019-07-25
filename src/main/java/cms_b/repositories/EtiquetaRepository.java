package cms_b.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cms_b.model.Etiqueta;




public interface EtiquetaRepository extends CrudRepository<Etiqueta,String>{
	
	//random N1QL Queries
	
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND tipo = 'etiqueta'")
	List<Etiqueta> findAllEtiquetas();
	
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND  tipo = 'pageEtiqueta'")
	List<Etiqueta> findAllAmbitos();
	
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND  keyId = $keyId")
	List<Etiqueta> findByKeyId(@Param("keyId")String keyId);
	
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND id = $id")
	List<Etiqueta> findById1(@Param("id")String id);
	
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter}  AND docId = $docId")
	Etiqueta findByDocId(@Param("docId")String docId);
	
	
	List<Etiqueta> deleteByKeyId(String keyId);
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND $ambitoList IN pages")
	List<Etiqueta> findByAmbitos(@Param("ambitoList")String ambitoList);
}
