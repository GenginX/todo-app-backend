package com.kaczmarm.todosbackend.service;

import com.kaczmarm.todosbackend.dao.ToDoRepository;
import com.kaczmarm.todosbackend.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    private ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public Todo findById(int theId) throws Exception {
        Optional<Todo> result = toDoRepository.findById(theId);
        Todo theTodo = null;
        if (result.isPresent()) {
            theTodo = result.get();
        } else {
            throw new RuntimeException("Didn't find todo with provided id:" + theId);
        }
        return theTodo;
    }

    @Override
    public void save(Todo theTodo) {
        toDoRepository.save(theTodo);
    }

    @Override
    public void deleteById(int theId) {
        toDoRepository.deleteById(theId);
    }
}
