package com.security.spring_security.service;

import com.security.spring_security.model.Person;
import com.security.spring_security.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RegistrationService {

    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PersonRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
        var encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        repository.save(person);
    }
}
