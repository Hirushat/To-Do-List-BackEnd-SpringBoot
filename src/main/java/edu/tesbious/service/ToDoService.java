package edu.tesbious.service;

import edu.tesbious.dto.ToDo;
import edu.tesbious.entity.ToDoEntity;

import java.util.List;

public interface ToDoService {
    ToDoEntity createStudent(ToDo toDo);
    List<ToDo> retrieveTasks();

    boolean removeTask(Long id);
}
