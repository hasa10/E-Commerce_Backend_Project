package org.example.dto;

import lombok.Data;
import org.example.enums.UserRole;

@Data
public class User {
    private Long id;

    private String email;

    private String name;

    private UserRole userRole;
}
