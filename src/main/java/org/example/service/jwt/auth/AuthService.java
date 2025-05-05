package org.example.service.jwt.auth;

import org.example.dto.SignupRequest;
import org.example.dto.User;

public interface AuthService {
    User createUser(SignupRequest signupRequest);

   Boolean hasUserWithEmail(String email);

    void createAdminAccount();
}
