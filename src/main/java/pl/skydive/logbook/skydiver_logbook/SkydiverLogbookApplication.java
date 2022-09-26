package pl.skydive.logbook.skydiver_logbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("pl.skydive")
//@EnableWebMvc
@EnableJpaRepositories
@SpringBootApplication
public class SkydiverLogbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkydiverLogbookApplication.class, args);
    }

}
