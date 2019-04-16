package com.example.ProiectLicentaBackend.model;

import com.example.ProiectLicentaBackend.model.audit.DateAudit;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "USERNAME"
        }),
        @UniqueConstraint(columnNames = {
                "EMAIL"
        })
})

@Data
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String username;

    @NotBlank
    @Size(max = 40)
    private String address;

    @NotBlank
    @Size(max = 20)
    private String phoneNumber;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(@NotBlank @Size(max = 40) String username,
                @NotBlank @Size(max = 40) String address,
                @NotBlank @Size(max = 20) String phoneNumber,
                @NotBlank @Size(max = 40) @Email String email,
                @NotBlank @Size(max = 100) String password) {
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    //ew User(signUpRequest.getName(), signUpRequest.getUsername(),
    //                signUpRequest.getEmail(), signUpRequest.getPassword());


}
