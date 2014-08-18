package com.troshchuk.photoLibrary.config;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:mysql.properties"})
@ComponentScan({"com.troshchuk.photoLibrary.domain",
                "com.troshchuk.photoLibrary.repository"})
public class HibernateConfig {

    @Autowired
    private Environment env;

    public HibernateConfig() {
        super();
    }

    @Bean
    public SessionFactory sessionFactory() {
        final LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();

        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan("com.troshchuk.photoLibrary.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());sessionFactory.getConfiguration();
        return sessionFactory.getObject();
    }

    @Bean
    public DataSource restDataSource() {
        final DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(
            final SessionFactory sessionFactory) {
        final HibernateTransactionManager txManager =
                new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
                                        env.getProperty(
                                                "hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect",
                                        env.getProperty("hibernate.dialect"));

        hibernateProperties.setProperty("hibernate.show_sql", "true");
        // hibernateProperties.setProperty("hibernate.format_sql", "true");
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");

        return hibernateProperties;
    }
}
