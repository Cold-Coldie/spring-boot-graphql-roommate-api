package com.coldie.roommategraphqlapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Roommate {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "8"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String course;

    private int level;

    public Roommate(Long id, String firstName, String lastName, String course, int level) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.level = level;
    }

    public Roommate(String firstName, String lastName, String course, int level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.level = level;
    }

    public Roommate(String firstName, String lastName, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.level = 100;
    }

    public Roommate() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
