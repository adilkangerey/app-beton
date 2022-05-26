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
@EnableJpaRepositories(basePackages = "barakat.app.aggregator.entity.app", entityManagerFactoryRef = "appEntityManager", transactionManagerRef = "appTransactionManager")
public class AppDBConfiguration {
    @Autowired
    private Environment env;

    public AppDBConfiguration() {
        super();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean appEntityManager() {
        System.out.println("loading config");
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(appDataSource());
        em.setPackagesToScan("barakat.app.aggregator.entity.app");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("app.datasource.thisapp-hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("app.datasource.thisapp-hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("app.datasource.thisapp-hibernate.show-sql"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix="app.datasource.thisapp")
    public DataSource appDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Primary
    @Bean
    public PlatformTransactionManager appTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(appEntityManager().getObject());
        return transactionManager;
    }

}