package ru.buharov.microservices.producer.jokes.service;

import ru.buharov.microservices.common.dto.JokeDTO;

public interface JokeService {

    JokeDTO getJoke();
}
