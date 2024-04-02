package edu.tesbious.controller;

import edu.tesbious.dto.Response;
import edu.tesbious.dto.ToDo;
import edu.tesbious.entity.ToDoEntity;
import edu.tesbious.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
public class ToDoController {

    @Autowired
    ToDoService service;

    @PostMapping("/todo")
    ToDoEntity createToDo(@RequestBody ToDo toDo){
        return service.createStudent(toDo);
    }

    @GetMapping("/todo")
    List<ToDo> retreiveTasks(){
        return service.retrieveTasks();
    }

    @DeleteMapping("/todo/{taskId}")
    Response deleteTask(@PathVariable Long taskId){
        return service.removeTask(taskId) ?
                new Response("Removed Task") :
                new Response(String.format("Task Id(%s) Invalid",taskId));

    }

}
