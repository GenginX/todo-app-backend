package com.kaczmarm.todosbackend.service;

import com.kaczmarm.todosbackend.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ToDoService {

    public List<Todo> findAll();

    public Todo findById(int theId) throws Exception;

    public void save(Todo todo);

    public void deleteById(int theId);
}
