package main.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import main.model.Neuter;
import main.service.impl.NeuterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToDoControllerGraph implements GraphQLQueryResolver {

    @Autowired
    private NeuterServiceImpl neuterService;

    public List<Neuter> getNeuters(final int count) {
        return this.neuterService.list();
    }
}
