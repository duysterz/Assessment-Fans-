package learn.fan_site;

import org.springframework.boot.SpringApplication;
<<<<<<< HEAD
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//
//@EnableAutoConfiguration
=======
import org.springframework.boot.autoconfigure.SpringBootApplication;

>>>>>>> 58e80759658a9dfe3eefa057ec5ba934c3febe4f
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }

}
