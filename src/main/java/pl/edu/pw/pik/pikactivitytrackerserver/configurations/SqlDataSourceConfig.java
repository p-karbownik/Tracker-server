package pl.edu.pw.pik.pikactivitytrackerserver.configurations;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = true)
public class SqlDataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("sql.datasource")
    public DataSource getDataSource()
    {
        return DataSourceBuilder.create().build();
    }

    public @Bean
    MongoClient mongoClient()
    {
        return MongoClients.create(System.getenv("MD_URI"));
    }

    public @Bean
    MongoTemplate mongoTemplate()
    {
        return new MongoTemplate(mongoClient(), "pik");
    }

}
