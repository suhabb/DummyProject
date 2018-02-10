package configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class,DataSourceAutoConfiguration.class})
@ComponentScan("${scan.packages}")
@ImportResource("mongdo-config.xml")
@EnableAspectJAutoProxy
public class ShowMeCode implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShowMeCode.class, args);
    }

    public void run(String... args) {
        System.out.println("ShowMeCode.run:"+args[0]);

    }
    
}
