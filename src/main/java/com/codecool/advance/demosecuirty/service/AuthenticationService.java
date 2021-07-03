package com.codecool.advance.demosecuirty.service;

import com.codecool.advance.demosecuirty.model.Customer;
import com.codecool.advance.demosecuirty.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
@AllArgsConstructor
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository repository;

    @PostConstruct
    public void init(){
        repository.save(new Customer(UUID.randomUUID(), "codecool", passwordEncoder.encode("1234")));
        repository.save(new Customer(UUID.randomUUID(), "codecool2", passwordEncoder.encode("codecool")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findCustomerByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }


}
