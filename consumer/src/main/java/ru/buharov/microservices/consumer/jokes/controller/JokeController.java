package ru.buharov.microservices.consumer.jokes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buharov.microservices.common.dto.JokeDTO;
import ru.buharov.microservices.consumer.jokes.service.JokeService;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/list")
    public List<JokeDTO> getRandomJoke() {
        return jokeService.getJokes();
    }
}
