package com.example.apibiblioteca.services.implement;

import com.example.apibiblioteca.domain.Recurso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IRecursoService {
    Mono<Recurso> save (Recurso recurso);
    Mono<Recurso> delete (String id);
    Mono<Recurso> findById (String id);
    Flux<Recurso> findAll();
}
