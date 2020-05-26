package ru.buharov.microservices.common.dto;

import lombok.Data;

@Data
public class JokeDTO {

    private String setup;
    private String punchline;
}
