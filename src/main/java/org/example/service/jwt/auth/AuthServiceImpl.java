package org.example.service.jwt.auth;

import lombok.RequiredArgsConstructor;
import org.example.repository.UserDao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private UserDao userDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
}
