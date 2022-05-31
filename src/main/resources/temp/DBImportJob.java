package temp;

import barakat.app.aggregator.entity.tctransport.batch.BkCategoriesItemProcessor;
import barakat.app.aggregator.entity.tctransport.model.gen.Bkcategories;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.*;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;


@Log4j2
//@Configuration
public class DBImportJob {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    TcTransportDBConfiguration tcTransportDBConfiguration ;

    @Autowired
    AppDBConfiguration appDBConfiguration;

    private String convertTableName(String name){
        return "\"" + name + "\"";
    }



    @Autowired
    HikariDataSource tctransportDataSource;

    @Autowired
    HikariDataSource appDataSource;

    @Bean
    public BkCategoriesItemProcessor processor() {
        return new BkCategoriesItemProcessor();
    }

    //    @Bean
//    @StepScope
//    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    JdbcCursorItemReader<Bkcategories> personReader() {
        String tableName = convertTableName(Bkcategories.class.getAnnotation(Table.class).name());
        JdbcCursorItemReader<Bkcategories> databaseReader = new JdbcCursorItemReader<>();
        databaseReader.setDataSource(appDataSource);
        databaseReader.setSql("select * from "+ tableName);
        databaseReader.setRowMapper(new BeanPropertyRowMapper<>(Bkcategories.class));
        return databaseReader;
    }

//    public JdbcPagingItemReader<Bkcategories> reader() {
//        String tableName = convertTableName(Bkcategories.class.getAnnotation(Table.class).name());
//
//        return new JdbcPagingItemReaderBuilder<Bkcategories>()
//                .name("personItemReader")
//                .dataSource(appDataSource)
//                .queryProvider(queryProvider())
////                .parameterValues(parameterValues(id))
//                .rowMapper(new RowMapper() {
//                    @Override
//                    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
//                        return null;
//                    }
//                })
//                .pageSize(100)
//                .build();
//    }

    @Bean
    public PagingQueryProvider queryProvider() {
        SqlPagingQueryProviderFactoryBean providerFactory = new SqlPagingQueryProviderFactoryBean();

        Map<String, Order> sortKeys = new HashMap<>(2);
        sortKeys.put("ID", Order.ASCENDING);

        providerFactory.setDataSource(tctransportDataSource);
        providerFactory.setSelectClause("SELECT Clause");
        providerFactory.setFromClause("FROM Clause");
        providerFactory.setWhereClause("WHERE Clause");
        providerFactory.setSortKeys(sortKeys);
        PagingQueryProvider pagingQueryProvider = null;
        try {
            pagingQueryProvider = providerFactory.getObject();
        } catch (Exception e) {
            log.error("Failed to get PagingQueryProvider", e);
            throw new RuntimeException("Failed to get PagingQueryProvider", e);
        }

        return pagingQueryProvider;
    }

    private Map<String, Object> parameterValues(Long id) {

        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("1", id);

        return parameterValues;

    }

    @Bean
//    @StepScope
//    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JdbcBatchItemWriter<Bkcategories> writer( ) {
        String tableName = convertTableName(Bkcategories.class.getAnnotation(Table.class).name());

        return new JdbcBatchItemWriterBuilder<Bkcategories>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO "+tableName+" (id, name) VALUES (:id, :name)")
                .dataSource(appDataSource)
                .build();
//
//        String sql = "insert into " + tableName;
//        System.out.println("WRIIIIIIIIITE " + sql);
//        JdbcBatchItemWriter<Bkcategories> itemWriter = new JdbcBatchItemWriter<>();
//        System.out.println("WRIIIIIIIIITE2 " + sql);
//        itemWriter.setSql(sql);
//        System.out.println("WRIIIIIIIIITE3 " + sql);
//        itemWriter.setDataSource(appDataSource);
//        System.out.println("WRIIIIIIIIITE4 " + sql);
//        itemWriter
//                .setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        System.out.println("WRIIIIIIIIITE5 " + sql);
//        return itemWriter;
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

//    @Bean
//    public Step step1(JdbcBatchItemWriter<Bkcategories> writer) {
//        return stepBuilderFactory.get("step1")
//                .<Bkcategories, Bkcategories> chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer())
//                .build();
//    }
//
//    @Bean
//    public Job dbImportJob2(final JobBuilderFactory jobBuilderFactory, final StepBuilderFactory stepBuilderFactory) {
//        String tableName = convertTableName(Bkcategories.class.getAnnotation(Table.class).name());
//        Step step = stepBuilderFactory.get("Person1_FROM_DB1_TABLE")
//                .<Bkcategories, Bkcategories>chunk(1000)
//                .reader(personReader("select * from "+ tableName))
//                .writer(writer("insert into " + tableName))
//                .build();
//
//        return jobBuilderFactory.get("personImportJob")
//                .incrementer(new RunIdIncrementer())
//                .start(step)
//                //.next(person2)
//                .build();
//    }
}
