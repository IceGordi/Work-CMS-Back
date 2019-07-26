package cms_b.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.query.Consistency;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

@ComponentScan({"cms_b.controller", "cms_b.service,cms_b.model"})
@PropertySource("classpath:application.properties")
@Configuration
@EnableSpringDataWebSupport
@EnableCouchbaseRepositories(basePackages = {"cms_b.repositories"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration{

	protected static final Logger logger = LoggerFactory.getLogger(CouchbaseConfig.class);
	
	@Autowired
	  private CouchbaseSettings couchbaseSettings;
	
	@Override
	  protected List<String> getBootstrapHosts() {
	    logger.info("Registering host '{}' for couchbase cluster", couchbaseSettings.getHostsNames());
	    return couchbaseSettings.getHostsNames();
	  }
	
	@Override
	  protected String getBucketName() {
	    logger.info("Opening bucket '{}'", couchbaseSettings.getBucketName());
	    return couchbaseSettings.getBucketName();
	}	
	
	
	  @Override
	  protected String getBucketPassword() {
	    return couchbaseSettings.getPassword();
	  }

	  @Override
	  protected CouchbaseEnvironment getEnvironment() {
	    DefaultCouchbaseEnvironment.builder().connectTimeout(60000) // by default 5 sec (5000 ms)
	        .queryTimeout(20000) // by default 75 sec (75000 ms)
	        .socketConnectTimeout(45000); // by default 1 sec (1000 ms)
	    return super.getEnvironment();
	  }
	  
	  @Override
	  public Consistency getDefaultConsistency() {
	    // By default, READ_YOUR_OWN_WRITES
	    // Values: READ_YOUR_OWN_WRITES, STRONGLY_CONSISTENT, UPDATE_AFTER, EVENTUALLY_CONSISTENT
	    return Consistency.READ_YOUR_OWN_WRITES;
	  }

	  @Override
	  public String typeKey() {
	    // By default, this attribute is named "_class".
	    // Spring Data automatically adds to each document an attribute containing the full class name of
	    // the entity.
	    // This field is the one used by N1QL queries to filter only documents corresponding to the
	    // repository’s entity.
	    return "type";
	  }
	  @Override
	  public void configureRepositoryOperationsMapping(RepositoryOperationsMapping baseMapping) {}
}
