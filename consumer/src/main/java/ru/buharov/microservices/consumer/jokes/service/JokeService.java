package ru.buharov.microservices.consumer.jokes.service;

import java.util.List;

import ru.buharov.microservices.common.dto.JokeDTO;

public interface JokeService {
    List<JokeDTO> getJokes();

    JokeDTO saveJoke(JokeDTO jokeDTO);
}
