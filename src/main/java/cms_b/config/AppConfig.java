package cms_b.config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({CouchbaseSettings.class /* other setting classes */})
public class AppConfig {}
