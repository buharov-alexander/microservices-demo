package ru.buharov.microservices.consumer.kafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {
    @Value("${kafka.address}")
    private String kafkaAddress;

    @Value("${kafka.topic.name}")
    private String kafkaTopicName;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);

        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic(kafkaTopicName, 1, (short) 1);
    }

}
