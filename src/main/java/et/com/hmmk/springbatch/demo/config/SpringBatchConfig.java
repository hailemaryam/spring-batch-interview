package et.com.hmmk.springbatch.demo.config;

import et.com.hmmk.springbatch.demo.entity.Patient;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private CustomerWriter customerWriter;

    private CustomReader customReader;

    @Bean
    public FlatFileItemReader<Patient> reader(){
        return customReader.reader();
    }


    @Bean
    public CustomProcessor processor(){
        return new CustomProcessor();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("csv-step").<Patient,Patient>chunk(1000)
                .reader(reader())
                .processor(processor())
                .writer(customerWriter)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runJob(){
        return jobBuilderFactory.get("importCustomers")
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(8);
        return asyncTaskExecutor;
    }
}
