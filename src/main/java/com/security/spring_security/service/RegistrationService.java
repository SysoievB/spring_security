package com.security.spring_security.service;

import com.security.spring_security.model.Person;
import com.security.spring_security.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RegistrationService {

    private final PersonRepository repository;

    @Autowired
    public RegistrationService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void register(Person person) {
        repository.save(person);
    }
}
