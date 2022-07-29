package main.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import main.model.Neuter;
import main.repository.NeuterRepository;
import main.service.impl.NeuterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    private final NeuterServiceImpl neuterService;
    private final NeuterRepository neuterRepository;

    @Autowired
    public QueryGraphQL(NeuterServiceImpl neuterService, NeuterRepository neuterRepository) {
        this.neuterService = neuterService;
        this.neuterRepository = neuterRepository;
    }

    @Transactional
    public List<Neuter> getNeuters() {
        return neuterService.list();
    }

    @Transactional
    public Neuter getNeuter(int id) {
        return neuterRepository.findById(id).orElse(null);
    }
}
