package barakat.app.aggregator;

import barakat.app.aggregator.entity.tctransport.dao.BkCategoriesRepository;
import barakat.app.aggregator.entity.tctransport.model.Bkcategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Hello");
    }

    @Autowired
    private BkCategoriesRepository bkcategoriesRepository;

    @Bean
    public void demo(){
        System.out.println(bkcategoriesRepository.count());;
        System.out.println(bkcategoriesRepository.count());;
        System.out.println(bkcategoriesRepository.count());;
        System.out.println(bkcategoriesRepository.count());;
        System.out.println(bkcategoriesRepository.count());;
        System.out.println(bkcategoriesRepository.count());;

    }



}
