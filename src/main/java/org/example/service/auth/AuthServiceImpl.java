package org.example.service.auth;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.dto.SignupRequest;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.enums.UserRole;
import org.example.repository.UserDao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserDao userDao;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(SignupRequest signupRequest) {
        UserEntity user = new UserEntity();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);

        UserEntity createdUser = userDao.save(user);

        User userDto = new User();
        userDto.setId(createdUser.getId());
        userDto.setName(createdUser.getName());
        userDto.setEmail(createdUser.getEmail());
        userDto.setUserRole(createdUser.getRole());


        return userDto;
    }

    @Override
    public Boolean hasUserWithEmail(String email) {
        return userDao.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdminAccount(){
        UserEntity adminAccount = userDao.findByRole(UserRole.ADMIN);
        if(null == adminAccount){
            UserEntity user = new UserEntity();
            user.setEmail("admin@gmail.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userDao.save(user);
        }
    }
}
