package com.example.demo.entity;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Person", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" )
    private Integer id;
    @Column(name="Email",unique = true, nullable = false, length = 100)
    private String email;
    @Column(name="Password", nullable = false, length = 100)
    private String password;
}
