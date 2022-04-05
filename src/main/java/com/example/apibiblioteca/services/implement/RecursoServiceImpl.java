package com.example.apibiblioteca.services.implement;

import com.example.apibiblioteca.domain.Recurso;
import com.example.apibiblioteca.repository.IRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecursoServiceImpl implements IRecursoService{

    @Autowired
    private IRecursoRepository iRecursoRepository;

    @Override
    public Mono<Recurso> save(Recurso recurso) {
        return this.iRecursoRepository.save(recurso);
    }

    @Override
    public Mono<Recurso> delete(String id) {
        return this.iRecursoRepository.findById(id)
                .flatMap(recurso -> this.iRecursoRepository.deleteById(id)
                        .thenReturn(recurso));
    }

    @Override
    public Mono<Recurso> findById(String id) {
        return this.iRecursoRepository.findById(id);
    }

    @Override
    public Flux<Recurso> findAll() {
        return this.iRecursoRepository.findAll();
    }
}
