package barakat.app.aggregator;

import barakat.app.aggregator.entity.tctransport.repository.WmainCustomRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@Log4j2
@EnableScheduling
@Profile({"test", "test-pg", "test-hamachi"})
public class Application {
    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
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







}
