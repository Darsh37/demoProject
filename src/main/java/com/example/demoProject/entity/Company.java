package com.example.demoProject.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="company1")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private int compId;

    @Column(name = "comp_name")
    private String compName;

    @OneToMany(mappedBy = "company1", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<Employee> employees;

}
