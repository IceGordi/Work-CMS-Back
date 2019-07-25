package cms_b.config;


import java.util.List;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "couchbase")
public class CouchbaseSettings {
	  protected static final Logger logger = LoggerFactory.getLogger(CouchbaseSettings.class);

	  private List<String> hostsNames;

	  private String bucketName;

	  private String password;
	  
	  public CouchbaseSettings() {
		    logger.info("Loading Couchbase properties");
		  }

		  @PostConstruct
		  public void postConstruct() {
		    logger.info("Couchbase properties -> hostName: '{}', bucketName: '{}', password: '{}'", hostsNames, bucketName,
		        password);
		  }

		  public List<String> getHostsNames() {
				return hostsNames;
		  }
			
		  public void setHostsNames(List<String> hostsNames) {
				this.hostsNames = hostsNames;
		  }

		  public String getBucketName() {
		    return bucketName;
		  }

		  public void setBucketName(String bucketName) {
		    this.bucketName = bucketName;
		  }

		  public String getPassword() {
		    return password;
		  }

		  public void setPassword(String password) {
		    this.password = password;
		  }

}
