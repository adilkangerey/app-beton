package temp;

import barakat.app.aggregator.entity.tctransport.model.gen.Bkcategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private String convertTableName(String name){
        return "\"" + name + "\"";
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.STARTING) {
            log.info("!!! JOB FINISHED! Time to verify the results");
            String tableName = convertTableName(Bkcategories.class.getAnnotation(Table.class).name());

            jdbcTemplate.query("SELECT name FROM dd",((rs, row) ->
                    {
                        Bkcategories bkcategories = new Bkcategories();
                        bkcategories.setName(rs.getString(1));
                        return bkcategories;
                    })
            ).forEach(person -> log.info("Found <" + person + "> in the database."));
        }
    }
}