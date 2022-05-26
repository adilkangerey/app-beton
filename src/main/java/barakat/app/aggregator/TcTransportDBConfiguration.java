package barakat.app.aggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(basePackages = "barakat.app.aggregator.entity.tctransport.repository", entityManagerFactoryRef = "tctransportEntityManager", transactionManagerRef = "tctransportTransactionManager")
public class TcTransportDBConfiguration {
    @Autowired
    private Environment env;

    public TcTransportDBConfiguration() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean tctransportEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(tctransportDataSource());
        em.setPackagesToScan("barakat.app.aggregator.entity.tctransport.model");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("app.datasource.tctransport-hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("app.datasource.tctransport-hibernate.dialect"));
        properties.put("hibernate.physical_naming_strategy", env.getProperty("app.datasource.tctransport-hibernate.physical_naming_strategy"));
        properties.put("hibernate.show_sql", env.getProperty("app.datasource.tctransport-hibernate.show-sql"));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @ConfigurationProperties(prefix="app.datasource.tctransport")
    public DataSource tctransportDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    public PlatformTransactionManager tctransportTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(tctransportEntityManager().getObject());
        return transactionManager;
    }

}