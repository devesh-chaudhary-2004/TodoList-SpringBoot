package com.example.todolist.service;

import com.example.todolist.model.TodoModel;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo){
        this.repo = repo;
    }

    public TodoModel add(TodoModel todo){
        return repo.save(todo);
    }

    public List<TodoModel> getAll(String userId){
        return repo.findByUserId(userId);
    }

    public List<TodoModel> getCompleted(String userId){
        return repo.findByUserIdAndCompleted(userId,true);
    }

    public List<TodoModel> getPending(String userId){
        return repo.findByUserIdAndCompleted(userId,false);
    }

    public TodoModel markComplete(String id){
        TodoModel todo = repo.findById(id).orElseThrow();
        todo.setCompleted(true);
        return repo.save(todo);
    }
}


