package com.example.db_2.Configuration;

/*
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
//import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration {
/*
    protected EclipseLinkJpaConfiguration(DataSource dataSource, JpaProperties properties,
                                          ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(PersistenceUnitProperties.WEAVING, true);
        map.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
        return map;
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactory(
            EntityManagerFactoryBuilder builder, DataSource dataSource) {

           return builder
              .dataSource(dataSource)
              .packages("com.example.db_2.com.example.db_2.POJO")
              .persistenceUnit("TelcoEJB")
              .properties(initJpaProperties()).build();
          }


    @Bean
    public static DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("Spring");
        dataSource.setPassword("Spring");
        return dataSource;
    }


    @Bean
    @Primary
    public static JpaProperties properties() {
        final JpaProperties jpaProperties = new JpaProperties();
        jpaProperties.setShowSql(true);
        jpaProperties.setDatabasePlatform("org.eclipse.persistence.platform.database.MySQLPlatform");
        return jpaProperties;
    }


    private static Map<String, ?> initJpaProperties() {
        final Map<String, Object> ret = new HashMap<>();
        // Add any JpaProperty you are interested in and is supported by your Database and JPA implementation
        ret.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
        ret.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINEST_LABEL);
        ret.put(PersistenceUnitProperties.WEAVING, "false");
        ret.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
        ret.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_DATABASE_GENERATION);
        return ret;
    }

}*/