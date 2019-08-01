package cms_b;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CmsBeta1Application {

	  protected static final Logger logger = LoggerFactory.getLogger(CmsBeta1Application.class);
	
	public static void main(String[] args) {
		logger.info("Starting Application");
		SpringApplication.run(CmsBeta1Application.class, args);
	}

}
