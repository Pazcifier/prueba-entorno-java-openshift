package com.example.demografana;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoGrafanaApplication {

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        String config = System.getenv("CONFIG");
        System.out.println(env);
        System.out.println(config);
        /*
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
        */
       // SpringApplication.run(DemoGrafanaApplication.class, args);
    }

}
