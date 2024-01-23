package com.coldie.roommategraphqlapi.repository;

import com.coldie.roommategraphqlapi.entity.Roommate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoommateRepository extends CrudRepository<Roommate, Long> {
    @Query("SELECT new com.coldie.roommategraphqlapi.entity.Roommate(r.id, r.firstName, r.lastName, r.course, r.level) FROM Roommate r WHERE r.level = :level")
    Iterable<Roommate> findRoommateByLevel(int level);
}
