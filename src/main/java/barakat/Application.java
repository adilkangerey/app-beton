package barakat;

import barakat.tctransport.repository.WmainCustomRepository;
import barakat.report.JasperException;
import barakat.report.Report;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Log4j2
@EnableScheduling
@EnableWebMvc
@Profile({"test", "test-pg", "test-hamachi"})
public class Application implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Configure the {@link HttpMessageConverter HttpMessageConverter}s for
     * reading from the request body and for writing to the response body.
     * <p>By default, all built-in converters are configured as long as the
     * corresponding 3rd party libraries such Jackson JSON, JAXB2, and others
     * are present on the classpath.
     * <p><strong>Note</strong> use of this method turns off default converter
     * registration. Alternatively, use
     * {@link #extendMessageConverters(List)} to modify that default
     * list of converters.
     *
     * @param converters initially an empty list of converters
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(byteArrayHttpMessageConverter());
//    }
//
//    @Bean
//    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
//        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
//        arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
//        return arrayHttpMessageConverter;
//    }

    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.IMAGE_JPEG);
        list.add(MediaType.IMAGE_PNG);
//        list.add(MediaType.APPLICATION_OCTET_STREAM);
        list.add(MediaType.APPLICATION_PDF);
        return list;
    }

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);


//        System.out.println("Hello");

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



    public String main(Report report) throws JasperException {
        log.info("startttttt main");
        report.demo2();
        return null;
    }





}
