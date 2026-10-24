package com.example.backend.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
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
}
