package gioelefriggia.sassariSoccorso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("gioelefriggia.sassariSoccorso.entities")
@EnableJpaRepositories("gioelefriggia.sassariSoccorso.repositories")
@PropertySource("classpath:env.properties")
public class SassariSoccorsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SassariSoccorsoApplication.class, args);
    }
}
