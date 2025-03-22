package com.listapplication.To.Do.Application.repository;

import com.listapplication.To.Do.Application.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
