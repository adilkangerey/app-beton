package barakat.app.aggregator;

import barakat.app.aggregator.entity.tctransport.repository.WmainCustomRepository;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableBatchProcessing
@EnableScheduling
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


    @Bean
    public void demo(){
//        System.out.println(wmainRepository.count());
//        bkcategoriesCustomRepository.findActive();
//        wmainRepository.findAll(PageRequest.of(0, 10)).getContent().stream().forEach(it->System.out.println(it.toString()));;
    }






}
