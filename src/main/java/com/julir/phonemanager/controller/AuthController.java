package com.julir.phonemanager.controller;

import com.julir.phonemanager.dto.JwtDto;
import com.julir.phonemanager.dto.SignInDto;
import com.julir.phonemanager.dto.SignUpDto;
import com.julir.phonemanager.model.User;
import com.julir.phonemanager.service.AuthService;
import com.julir.phonemanager.service.TokenProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private AuthService authService;

  @Autowired
  private TokenProvider tokenService;

  @PostMapping("/signup")
  public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) {
    authService.signUp(data);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
    UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
    Authentication authUser = authenticationManager.authenticate(usernamePassword);
    String accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());
    return ResponseEntity.ok(JwtDto.builder().token(accessToken).build());
  }
}
