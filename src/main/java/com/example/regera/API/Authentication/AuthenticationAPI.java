package com.example.regera.API.Authentication;

import com.example.regera.Model.Request.AuthenticationRequest;
import com.example.regera.Model.Response.AuthenticationResponse;
import com.example.regera.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationAPI {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value="/login")
    public AuthenticationResponse checkLogin(@RequestBody AuthenticationRequest authenticationRequest){
        return authenticationService.authenticate(authenticationRequest);
    }
}
