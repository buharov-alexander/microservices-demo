package ru.buharov.microservices.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.buharov.microservices.consumer.kafka.MessageListener;

@SpringBootApplication
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    @Bean
    public MessageListener messageListener() {
        return new MessageListener();
    }
}
