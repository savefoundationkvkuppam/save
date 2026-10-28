package com.example.backend.config;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
// Only active on services that have SECONDARY_DB_URL set in Render.
// Services without it start normally and use their own main database.
@Configuration
@ConditionalOnProperty(name = "SECONDARY_DB_URL")
public class SecondaryDatabaseConfig {
 
    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource(
            @Value("${SECONDARY_DB_URL}") String url,
            @Value("${SECONDARY_DB_USERNAME}") String username,
            @Value("${SECONDARY_DB_PASSWORD}") String password) {
 
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
 
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
 
        return dataSource;
    }
 
    @Bean(name = "secondaryJdbcTemplate")
    public org.springframework.jdbc.core.JdbcTemplate secondaryJdbcTemplate(
            @org.springframework.beans.factory.annotation.Qualifier("secondaryDataSource")
            DataSource dataSource) {
        return new org.springframework.jdbc.core.JdbcTemplate(dataSource);
    }
}
