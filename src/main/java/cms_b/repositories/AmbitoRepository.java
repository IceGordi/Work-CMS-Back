package cms_b.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import cms_b.model.Ambito;


public interface AmbitoRepository extends CouchbaseRepository<Ambito,String>,AmbitoRepositoryCustom{
	@Query("#{#n1ql.selectEntity} WHERE type = 'ambito'")
	List<Ambito> findAllAmbitos();
	Ambito findByKeyId(String keyId);
	Ambito deleteByKeyId (String keyId);
}
