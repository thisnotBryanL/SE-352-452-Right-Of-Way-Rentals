package edu.depaul.cdm.se452.rightOfWayRentals.data.model;

import edu.depaul.cdm.se452.rightOfWayRentals.data.pojo.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private Role role;

    public Employee(final String name, final Role role) {
        this.name = name;
        this.role = role;
    }

}
