package com.example.apibiblioteca.repository;

import com.example.apibiblioteca.domain.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IRecursoRepository extends ReactiveMongoRepository<Recurso, String> {

}
