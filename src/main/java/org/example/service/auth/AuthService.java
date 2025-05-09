package org.example.service.auth;

import org.example.dto.SignupRequest;
import org.example.dto.User;

public interface AuthService {
    User createUser(SignupRequest signupRequest);

   Boolean hasUserWithEmail(String email);

    void createAdminAccount();
}
