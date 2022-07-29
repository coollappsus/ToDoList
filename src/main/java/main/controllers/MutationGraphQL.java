package main.controllers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import main.model.Neuter;
import main.repository.NeuterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MutationGraphQL implements GraphQLMutationResolver {

    private final NeuterRepository neuterRepository;

    @Autowired
    public MutationGraphQL(NeuterRepository neuterRepository) {
        this.neuterRepository = neuterRepository;
    }

    @Transactional
    public Neuter addNeuter(String name) {
        Neuter neuter = new Neuter(name);
        neuter.setDate(System.currentTimeMillis());
        return neuterRepository.save(neuter);
    }

    @Transactional
    public int deleteNeuter(int id) {
        neuterRepository.deleteById(id);
        return id;
    }

    @Transactional
    public boolean deleteNeuters() {
        neuterRepository.deleteAll();
        return true;
    }
}
