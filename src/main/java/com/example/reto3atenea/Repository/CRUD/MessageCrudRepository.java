package com.example.reto3atenea.Repository.CRUD;

import com.example.reto3atenea.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
