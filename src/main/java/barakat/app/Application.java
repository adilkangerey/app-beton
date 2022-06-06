package barakat.app;

import barakat.app.aggregator.entity.tctransport.repository.WmainCustomRepository;
import barakat.app.report.JasperException;
import barakat.app.report.Report;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@Log4j2
@EnableScheduling
@Profile({"test", "test-pg"})
public class Application {
    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
        System.out.println("Hello");

//        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
//
//        JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
//        Job dbImportJob= (Job) ctx.getBean("DBImportJob");
//        jobLauncher.run(dbImportJob, newExecution("DBImportJob"));
    }

//    private static JobParameters newExecution(String jobName) {
//        return new JobParametersBuilder().addDate("date", new Date())
//                .addLong("time", System.currentTimeMillis())
//                .addString("jobName", jobName)
//                .toJobParameters();
//
//    }

    @Autowired
    private WmainCustomRepository wmainRepository;


    @Bean
    public String main(Report report) throws JasperException {
        log.info("startttttt main");
        report.demo2();
        return null;
    }





}
