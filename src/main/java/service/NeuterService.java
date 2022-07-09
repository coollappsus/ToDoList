package service;

import entity.Neuter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface NeuterService {

    List<Neuter> list();
    int add(Neuter neuter);
    ResponseEntity get(@PathVariable int id);
    int deleteAll(@PathVariable int id);
    int deleteAll();

}
