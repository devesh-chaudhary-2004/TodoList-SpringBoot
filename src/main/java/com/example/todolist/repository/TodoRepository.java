package com.example.todolist.repository;

import com.example.todolist.model.TodoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<TodoModel,String> {

    List<TodoModel> findByUserId(String userId);

    List<TodoModel> findByUserIdAndCompleted(String userId, Boolean completed);
}


