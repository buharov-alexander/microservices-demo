package ru.buharov.microservices.consumer.jokes.service;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import ru.buharov.microservices.common.dto.JokeDTO;
import ru.buharov.microservices.consumer.jokes.repositories.JokeRepository;

@Service
public class JokeServiceImpl implements JokeService {

    private JokeRepository jokeRepository;

    public JokeServiceImpl(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @Override public List<JokeDTO> getJokes() {
        return Lists.newArrayList(jokeRepository.findAll());
    }

    @Override
    public JokeDTO saveJoke(JokeDTO jokeDTO) {
        return jokeRepository.save(jokeDTO);
    }
}
