package com.security.spring_security.service;

import com.security.spring_security.model.Person;
import com.security.spring_security.repository.PersonRepository;
import com.security.spring_security.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository repository;

    @Autowired
    public PersonDetailsService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> personOptional = repository.findByUsername(username);

        if (personOptional.isEmpty()) throw new UsernameNotFoundException("User not found!!");

        return new PersonDetails(personOptional.get());
    }
}
