package ru.buharov.microservices.producer.jokes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buharov.microservices.common.dto.JokeDTO;
import ru.buharov.microservices.producer.jokes.service.JokeService;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/random")
    public JokeDTO getRandomJoke() {
        return jokeService.getJoke();
    }

    @GetMapping("/random/send")
    public JokeDTO sendRandomJoke() {
        return jokeService.sendJoke();
    }
}
