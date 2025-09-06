package org.example.micro.demo.tasktracker.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {


    @Test
    void equals_shouldReturnTrueForSameId() {
        UUID id = UUID.randomUUID();

        Task task1 = new Task();
        task1.setId(id);

        Task task2 = new Task();
        task2.setId(id);

        assertThat(task1).isEqualTo(task2);
        assertThat(task1.hashCode()).isEqualTo(task2.hashCode());
    }

    @Test
    void equals_shouldReturnFalseForDifferentIds() {
        Task task1 = new Task();
        task1.setId(UUID.randomUUID());

        Task task2 = new Task();
        task2.setId(UUID.randomUUID());

        assertThat(task1).isNotEqualTo(task2);
    }

    @Test
    void equals_shouldReturnFalseWhenIdIsNull() {
        Task task1 = new Task();
        task1.setId(null);

        Task task2 = new Task();
        task2.setId(UUID.randomUUID());

        assertThat(task1).isNotEqualTo(task2);
    }

    @Test
    void performers_shouldBeMutable() {
        Task task = new Task();
        User user = new User();
        user.setId(UUID.randomUUID());

        task.setPerformers(List.of(user));

        assertThat(task.getPerformers())
                .hasSize(1)
                .first()
                .isEqualTo(user);
    }
}