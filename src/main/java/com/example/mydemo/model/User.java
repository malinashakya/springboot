package com.example.mydemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity()
@Table(name = "users",uniqueConstraints =
        {@UniqueConstraint(name="user_name_unique",
                columnNames = "userName"),
                @UniqueConstraint(name="user_email",
                        columnNames = "email")})

public class User {
    @Id
    private Long id;
    @Column(nullable = false,length = 20)
    private String userName;
    @Column(nullable = false,length=50,columnDefinition = "VARCHAR(50)")
    private String email;

}
