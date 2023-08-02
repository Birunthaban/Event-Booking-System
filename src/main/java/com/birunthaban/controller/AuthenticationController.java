package com.birunthaban.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birunthaban.model.AuthenticationRequest;
import com.birunthaban.model.AuthenticationResponse;
import com.birunthaban.model.RegisterRequest;
import com.birunthaban.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/customer_signup")
  public ResponseEntity<AuthenticationResponse> signUpCustomer(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.signUpCustomer(request));
  }
  @PostMapping("/owner_signup")
  public ResponseEntity<AuthenticationResponse> signUpOwner(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.signUpOwner(request));
  }
  @PostMapping("/customer_signup")
  public ResponseEntity<AuthenticationResponse> signUpAdmin(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.signUpAdmin(request));
  }


  @PostMapping("/sign_in")
  public ResponseEntity<AuthenticationResponse> signIn(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.signIn(request));
  }


}
