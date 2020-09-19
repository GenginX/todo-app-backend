package com.kaczmarm.todosbackend.dao;

import com.kaczmarm.todosbackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Integer> {
}
