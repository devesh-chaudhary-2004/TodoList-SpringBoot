package com.example.todolist.controller;

import com.example.todolist.dto.TodoRequestDto;
import com.example.todolist.model.TodoModel;
import com.example.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin("*")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    @PostMapping("/{userId}")
    public TodoModel add(@PathVariable String userId, @RequestBody TodoRequestDto req){
        TodoModel todo = new Todo(userId, req.title, req.description, false);
        return service.add(todo);
    }

    @GetMapping("/{userId}")
    public List<Todo> all(@PathVariable String userId){
        return service.getAll(userId);
    }

    @GetMapping("/completed/{userId}")
    public List<Todo> completed(@PathVariable String userId){
        return service.getCompleted(userId);
    }

    @GetMapping("/pending/{userId}")
    public List<Todo> pending(@PathVariable String userId){
        return service.getPending(userId);
    }

    @PutMapping("/complete/{id}")
    public Todo mark(@PathVariable String id){
        return service.markComplete(id);
    }
}


