package pl.edu.pw.pik.pikactivitytrackerserver.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class SqlDataSourceConfig {
    @Bean
    @ConfigurationProperties("sql.datasource")
    public DataSource getDataSource()
    {
        return DataSourceBuilder.create().build();
    }
}
