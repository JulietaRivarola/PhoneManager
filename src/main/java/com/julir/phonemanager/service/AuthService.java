package com.julir.phonemanager.service;

import com.julir.phonemanager.dto.SignUpDto;
import com.julir.phonemanager.model.User;
import com.julir.phonemanager.model.UserRole;
import com.julir.phonemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    return repository.findByUsername(username);
  }

  public User signUp(SignUpDto data) {
    if (repository.findByUsername(data.getUsername()) != null) {
      throw new RuntimeException("Username already exists");
    }
    String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
    User newUser = User.builder().username(data.getUsername()).password(encryptedPassword).role(UserRole.valueOf(String.valueOf(UserRole.USER))).build();
    return repository.save(newUser);
  }
}
