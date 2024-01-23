package com.coldie.roommategraphqlapi.mutator;

import com.coldie.roommategraphqlapi.entity.Roommate;
import com.coldie.roommategraphqlapi.exception.RoommateNotFoundException;
import com.coldie.roommategraphqlapi.repository.RoommateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class Mutation {
    @Autowired
    RoommateRepository roommateRepository;

    @MutationMapping
    public Roommate newRoommate(@Argument String firstName, @Argument String lastName, @Argument String course, @Argument int level) {
        Roommate roommate = new Roommate(firstName, lastName, course, level);
        roommateRepository.save(roommate);
        return roommate;
    }

    @MutationMapping
    public Roommate updateRoommateLevel(@Argument int level, @Argument Long id) {
        Optional<Roommate> optionalRoommate = roommateRepository.findById(id);

        if (optionalRoommate.isPresent()) {
            Roommate roommate = optionalRoommate.get();
            roommate.setLevel(level);
            roommateRepository.save(roommate);
            return roommate;
        } else {
            throw new RoommateNotFoundException("No Roommate found with id " + id);
        }
    }

    @MutationMapping
    public boolean deleteRoommateById(@Argument Long id) {
        Optional<Roommate> optionalRoommate = roommateRepository.findById(id);

        if (optionalRoommate.isPresent()) {
            roommateRepository.deleteById(id);
            return true;
        } else {
            throw new RoommateNotFoundException("No Roommate found with id " + id);
        }
    }
}
