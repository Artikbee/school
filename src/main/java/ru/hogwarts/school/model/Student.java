package ru.hogwarts.school.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

}
