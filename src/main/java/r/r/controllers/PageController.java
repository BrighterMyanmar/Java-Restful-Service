package r.r.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.AuthenticationRequest;
import r.r.dtos.AuthenticationResponse;
import r.r.services.UserService;
import r.r.utils.JwtUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PageController {

   @Autowired
   AuthenticationManager authenticationManager;

   @Autowired
   UserService userService;

   @Autowired
   JwtUtil jwtUtil;

   // @RequestMapping(value = "/authenticate" , method= ReequestMethod.POST)

   @PostMapping(value = "/authenticate")
   public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest) {

      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
            authenticationRequest.getPassword()));

      final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

      final String jwt = jwtUtil.genToken(userDetails);
      return ResponseEntity.ok(new AuthenticationResponse(jwt));
   }

}
