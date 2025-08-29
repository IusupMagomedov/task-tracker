package org.example.micro.demo.tasktracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String fatherName;
    private String rank;
    private String jobTitle;
    private String jobDescription;
    private String securityRole;
    @ManyToMany(mappedBy = "performers", fetch = FetchType.LAZY)
    private List<Task> tasks;
}
