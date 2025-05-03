package org.example.entity;

import jakarta.persistence.*;
import jdk.jfr.Label;
import lombok.Data;
import org.example.enums.UserRole;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private UserRole role;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;
}
