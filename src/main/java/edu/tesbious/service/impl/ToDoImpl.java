package edu.tesbious.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tesbious.dto.ToDo;
import edu.tesbious.entity.ToDoEntity;
import edu.tesbious.repository.ToDoNativeRepository;
import edu.tesbious.repository.ToDoRepository;
import edu.tesbious.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ToDoImpl implements ToDoService {

    @Autowired
    ToDoNativeRepository toDoNativeRepository;

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ToDoEntity createStudent(ToDo toDo) {
        ToDoEntity entity = mapper.convertValue(toDo, ToDoEntity.class);
        toDoRepository.save(entity);
        return entity;
    }

    @Override
    public List<ToDo> retrieveTasks() {
        List<ToDo> list = new ArrayList<>();

        Iterable<ToDoEntity> taskList = toDoRepository.findAll();

        Iterator<ToDoEntity> iterator = taskList.iterator();

        while (iterator.hasNext()){
            ToDoEntity entity = iterator.next();
            ToDo toDo = mapper.convertValue(entity, ToDo.class);
            list.add(toDo);
        }

        return list;
    }

    @Override
    public boolean removeTask(Long id) {
        return toDoNativeRepository.removeTask(id);
    }
}
