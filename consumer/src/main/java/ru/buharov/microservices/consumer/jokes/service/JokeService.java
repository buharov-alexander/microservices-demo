package ru.buharov.microservices.consumer.jokes.service;

import ru.buharov.microservices.common.dto.JokeDTO;

public interface JokeService {
    JokeDTO saveJoke(JokeDTO jokeDTO);
}
