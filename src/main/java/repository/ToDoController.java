package repository;

import entity.Neuter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private NeuterRepository neuterRepository;

    @RequestMapping(value = "/list/", method = RequestMethod.GET)
    public List<Neuter> list() {
        Iterable<Neuter> neuterIterable = neuterRepository.findAll();
        ArrayList<Neuter> neuters = new ArrayList<>();
        for(Neuter neuter : neuterIterable) {
            neuters.add(neuter);
        }
        return neuters;
    }

    @RequestMapping(value = "/list/", method = RequestMethod.POST )
    public int add(Neuter neuter) {
        Neuter newNeuter = neuterRepository.save(neuter);
        return newNeuter.getId();
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable int id) {

        Optional<Neuter> optionalNeuter = neuterRepository.findById(id);
        if (!optionalNeuter.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalNeuter.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable int id) {
        neuterRepository.deleteById(id);
        return id;
    }

    @RequestMapping(value = "/list/", method = RequestMethod.DELETE)
    public int delete() {
        neuterRepository.deleteAll();
        if (list().isEmpty()) {
            return 0;
        }
        return 1;
    }

//    @RequestMapping(value = "/list/{id}", method = RequestMethod.PUT)
//    public int put(@PathVariable int id) {
//        Storage.putNeuter(id);
//        return 0;
//    }
//
//    @RequestMapping(value = "/list/", method = RequestMethod.PUT)
//    public int put() {
//        Storage.putAllNeuter();
//        return 0;
//    }
}