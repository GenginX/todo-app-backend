package com.kaczmarm.todosbackend.rest;

import com.kaczmarm.todosbackend.entity.Todo;
import com.kaczmarm.todosbackend.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoRestController {

    private ToDoService toDoService;

    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public List<Todo> findAll() {
        return toDoService.findAll();
    }

    @PostMapping("/todo")
    public Todo save(@RequestBody Todo theTodo) {
        theTodo.setId(0);
        toDoService.save(theTodo);
        return theTodo;
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") int todoId) throws Exception {
        Todo theTodo = toDoService.findById(todoId);
        if (theTodo == null) {
            throw new RuntimeException("Didn't find todo with provided id:" + todoId);
        }
        return theTodo;
    }

    @PutMapping("/todo")
    public Todo updateTodo(@RequestBody Todo theTodo){
        toDoService.save(theTodo);
        return theTodo;
    }
    @DeleteMapping("/todo/{id}")
    public String deleteTodo(@PathVariable("id") int todoId) throws Exception {
        Todo tempTodo = toDoService.findById(todoId);
        if(tempTodo == null){
            throw new RuntimeException("Didn't find todo with provided id:" + todoId);
        }
        toDoService.deleteById(todoId);
        return "Todo with id: " + todoId + " removed";
    }

}
