package com.example.apibiblioteca.web;

import com.example.apibiblioteca.domain.Recurso;
import com.example.apibiblioteca.services.implement.IRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class RecursoResource {
    @Autowired
    private IRecursoService iRecursoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Recurso> save (@RequestBody  Recurso recurso){
        return this.iRecursoService.save(recurso);
    }

    @PutMapping("/{id}")
    private Mono<ResponseEntity<Recurso>> delete (@PathVariable("id") String id){
        return this.iRecursoService.delete(id)
                .flatMap(recurso -> Mono.just(ResponseEntity.ok(recurso)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    private Flux<Recurso> findAll(){
        return this.iRecursoService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<Recurso> findById(@PathVariable("id") String id){
        return this.iRecursoService.findById(id);
    }

    @GetMapping("/estado/{id}")
    public ResponseEntity<Mono<Recurso>> findStatusById(@PathVariable("id") String id) {
        Mono<Recurso> resource = iRecursoService.findById(id);
        HttpStatus status = resource != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return  new ResponseEntity<>(resource, status);
    }

    @GetMapping("/prestado/{id}")
    public ResponseEntity<Mono<String>> prestado(@PathVariable("id") String id) {
            try {
                Boolean isPrestado = iRecursoService.findById(id)
                        .map(Recurso::getPrestado)
                        .block();

                if(!isPrestado) {
                    return new ResponseEntity<>(
                            Mono.just("NO DISPONIBLe"),
                            HttpStatus.FORBIDDEN);
                }
                return new ResponseEntity<>(Mono.just("DISPONIBLE"), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @PutMapping("/update/{id}")
    private Mono<ResponseEntity<Recurso>> devolver (@PathVariable("id") String id, @RequestBody Recurso recurso){
        return this.iRecursoService.devolver(id, recurso)
                .flatMap(productoDTOReactivo1 -> Mono.just(ResponseEntity.ok(recurso)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }



}


