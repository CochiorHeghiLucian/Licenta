package com.example.ProiectLicentaBackend.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@RequiredArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

}
