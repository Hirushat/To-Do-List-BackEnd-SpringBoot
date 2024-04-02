package edu.tesbious.repository.impl;

import edu.tesbious.entity.ToDoEntity;
import edu.tesbious.repository.ToDoNativeRepository;
import edu.tesbious.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Optional;
@Repository
public class ToDoNativeRepositoryImpl  implements ToDoNativeRepository{

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean removeTask(Long id) {
        return namedParameterJdbcTemplate.update("DELETE FROM to_do_entity WHERE ID=:id", Collections.singletonMap("id",id))>0;
    }
}
