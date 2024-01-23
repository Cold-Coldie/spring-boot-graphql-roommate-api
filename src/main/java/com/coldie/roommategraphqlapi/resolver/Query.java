package com.coldie.roommategraphqlapi.resolver;

import com.coldie.roommategraphqlapi.entity.Roommate;
import com.coldie.roommategraphqlapi.exception.RoommateNotFoundException;
import com.coldie.roommategraphqlapi.repository.RoommateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class Query {

    @Autowired
    RoommateRepository roommateRepository;

    @QueryMapping
    public Iterable<Roommate> findAllRoommates() {
        return roommateRepository.findAll();
    }

    @QueryMapping
    public Iterable<Roommate> findRoommateByLevel(@Argument int level) {
        return roommateRepository.findRoommateByLevel(level);
    }

    @QueryMapping
    public Roommate findRoommateById(@Argument Long id) {
        Optional<Roommate> optionalRoommate = roommateRepository.findById(id);

        if (optionalRoommate.isPresent()) {
            return optionalRoommate.get();
        } else {
            throw new RoommateNotFoundException("No Roommate found with id " + id);
        }
    }
}
