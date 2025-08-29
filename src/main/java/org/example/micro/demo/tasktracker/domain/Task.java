package org.example.micro.demo.tasktracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private UUID id;
    private String basis;
    private String shortName;
    private Periodicity periodicity;
    private String regulation;
    private String addressee;
    private long averageDuration;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "task_users",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> performers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
