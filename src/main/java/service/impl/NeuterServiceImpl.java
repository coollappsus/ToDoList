package service.impl;

import dto.NeuterDto;
import entity.Neuter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.NeuterRepository;
import service.NeuterService;
import utils.MappingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NeuterServiceImpl implements NeuterService {

    private MappingUtils mappingUtils;
    @Autowired
    private NeuterRepository neuterRepository;

    @Override
    public List<Neuter> list() {
        Iterable<Neuter> neuterIterable = neuterRepository.findAll();
        ArrayList<Neuter> neuters = new ArrayList<>();
        for (Neuter neuter : neuterIterable) {
            neuters.add(neuter);
        }
        return neuters;
    }

    @Override
    public int add(Neuter neuter) {
        Neuter newNeuter = neuterRepository.save(neuter);
        return newNeuter.getId();
    }

    @Override
    public ResponseEntity get(int id) {
        Optional<Neuter> optionalNeuter = neuterRepository.findById(id);
        if (!optionalNeuter.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalNeuter.get(), HttpStatus.OK);
    }

    @Override
    public int deleteAll(int id) {
        neuterRepository.deleteById(id);
        return id;
    }

    @Override
    public int deleteAll() {
        neuterRepository.deleteAll();
        if (list().isEmpty()) {
            return 0;
        }
        return 1;
    }

    public List<NeuterDto> findAll() {
        return neuterRepository.findAll().stream().map(mappingUtils::mapToProductDto).collect(Collectors.toList());
    }

    public NeuterDto findById(Integer id) {
        return mappingUtils.mapToProductDto(neuterRepository.findById(id).orElse(new Neuter()));
    }
}
