package ru.buharov.microservices.consumer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import ru.buharov.microservices.common.dto.JokeDTO;

@Slf4j
public class MessageListener {

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listener(JokeDTO jokeDTO) {
        log.info("Recieved message: {}", jokeDTO);
    }
}
