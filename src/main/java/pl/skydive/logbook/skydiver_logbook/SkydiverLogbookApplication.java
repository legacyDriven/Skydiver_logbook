package pl.skydive.logbook.skydiver_logbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("pl.skydive")
@SpringBootApplication
public class SkydiverLogbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkydiverLogbookApplication.class, args);
    }

}
