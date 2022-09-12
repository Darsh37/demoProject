package com.example.demoProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee1")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "comp_id")
    private int compId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comp_id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    private Company company1;



}
