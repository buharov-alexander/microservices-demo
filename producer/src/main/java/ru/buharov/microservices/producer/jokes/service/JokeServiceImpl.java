package ru.buharov.microservices.producer.jokes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.buharov.microservices.common.dto.JokeDTO;
import ru.buharov.microservices.producer.kafka.MessageProducer;

@Service
public class JokeServiceImpl implements JokeService {

    @Value("${joke.api.url}")
    private String url;
    private RestTemplate restTemplate;
    private MessageProducer messageProducer;

    public JokeServiceImpl(RestTemplate restTemplate, MessageProducer messageProducer) {
        this.restTemplate = restTemplate;
        this.messageProducer = messageProducer;
    }

    @Override
    public JokeDTO getJoke() {
        JokeDTO[] jokes = restTemplate.getForObject(url, JokeDTO[].class);
        if (jokes != null && jokes.length > 0) {
            return jokes[0];
        }
        return null;
    }

    @Override
    public JokeDTO sendJoke() {
        JokeDTO joke = getJoke();
        messageProducer.sendMessage(joke);
        return joke;
    }
}
