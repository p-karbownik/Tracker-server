package pl.edu.pw.pik.pikactivitytrackerserver.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class SqlDataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("sql.datasource")
    public DataSource getDataSource()
    {
        return DataSourceBuilder.create().build();
    }

}
