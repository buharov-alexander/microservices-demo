package ru.buharov.microservices.consumer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import ru.buharov.microservices.common.dto.JokeDTO;
import ru.buharov.microservices.consumer.jokes.service.JokeService;

@Slf4j
public class MessageListener {

    @Autowired
    private JokeService jokeService;

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listener(JokeDTO jokeDTO) {
        log.info("Recieved message: {}", jokeDTO);
        jokeService.saveJoke(jokeDTO);
    }
}
