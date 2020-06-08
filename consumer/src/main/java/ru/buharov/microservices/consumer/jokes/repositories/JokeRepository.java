package ru.buharov.microservices.consumer.jokes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.buharov.microservices.common.dto.JokeDTO;

@Repository
public interface JokeRepository extends CrudRepository<JokeDTO, String> {
}
