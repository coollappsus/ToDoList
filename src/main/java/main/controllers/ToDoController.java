package main.controllers;

import main.model.Neuter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.repository.NeuterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    private final NeuterRepository neuterRepository;

    @Autowired
    public ToDoController(NeuterRepository neuterRepository) {
        this.neuterRepository = neuterRepository;
    }

    @GetMapping(value = "/list")
    public List<Neuter> list() {
        Iterable<Neuter> neuterIterable = neuterRepository.findAll();
        ArrayList<Neuter> neuters = new ArrayList<>();
        for(Neuter neuter : neuterIterable) {
            neuters.add(neuter);
        }
        return neuters;
    }

    @PostMapping(value = "/list")
    public int add(Neuter neuter) {
        neuter.setDate(System.currentTimeMillis());
        Neuter newNeuter = neuterRepository.save(neuter);
        return newNeuter.getId();
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Neuter> optionalNeuter = neuterRepository.findById(id);
        return optionalNeuter.map(neuter -> new ResponseEntity(neuter, HttpStatus.OK)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping(value = "/list/{id}")
    public int delete(@PathVariable int id) {
        neuterRepository.deleteById(id);
        return id;
    }

    @DeleteMapping(value = "/list")
    public int delete() {
        neuterRepository.deleteAll();
        if (list().isEmpty()) {
            return 0;
        }
        return 1;
    }
}