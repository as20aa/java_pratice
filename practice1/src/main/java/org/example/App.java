package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
* java多线程实战
 * 使用spring-boot自带的线程池进行子线程的窗口，从而让完成耗时的后台工作
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

//    @Bean(name = "threadPoolTaskExecutor")
//    public Executor asyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(4);
//        executor.setMaxPoolSize(4);
//        executor.setQueueCapacity(50);
//        executor.setThreadNamePrefix("AsynchThread::");
//        executor.initialize();
//        return executor;
//    }
}
