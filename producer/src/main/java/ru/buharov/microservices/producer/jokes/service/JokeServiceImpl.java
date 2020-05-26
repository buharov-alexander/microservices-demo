package ru.buharov.microservices.producer.jokes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.buharov.microservices.common.dto.JokeDTO;

@Service
public class JokeServiceImpl implements JokeService {

    private String url;
    private RestTemplate restTemplate;

    public JokeServiceImpl(RestTemplate restTemplate, @Value("${joke.api.url}") String jokeApiUrl) {
        this.url = jokeApiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public JokeDTO getJoke() {
        JokeDTO[] jokes = restTemplate.getForObject(url, JokeDTO[].class);
        if (jokes != null && jokes.length > 0) {
            return jokes[0];
        }
        return null;
    }
}
