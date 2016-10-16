package configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="${scan.packages}")
public class DatabaseConfiguration extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String url;

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@SuppressWarnings("deprecation")
	public Mongo mongo() throws Exception {
		return new Mongo(new MongoURI(url));
	}

}
