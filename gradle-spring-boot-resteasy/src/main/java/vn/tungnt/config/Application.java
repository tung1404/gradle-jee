package vn.tungnt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot entry point application
 *
 * Created by facarvalho on 12/7/15.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"vn.tungnt.jpa.domain"})
@EnableJpaRepositories(basePackages = {"vn.tungnt.service.repositories"})
@EnableTransactionManagement
//@ComponentScan(basePackages = {"vn.tungnt"})
//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
