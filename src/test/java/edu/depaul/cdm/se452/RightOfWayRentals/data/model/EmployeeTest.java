package edu.depaul.cdm.se452.RightOfWayRentals.data.model;


import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.Role;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    @Test
    void testEmpty() {
        final Employee employee = new Employee();
        assertThat(employee.getId()).isZero();
        assertThat(employee.getName()).isNull();
        assertThat(employee.getRole()).isNull();
        assertThat(employee).isEqualTo(new Employee());
    }

    @Test
    void testEmployee() {
        final int id = 1;
        final String name = "John Doe";
        final Role role = Role.SALESMAN;
        final Employee john_doe = new Employee(id, name, role);
        assertThat(john_doe.getId()).isEqualTo(id);
        assertThat(john_doe.getName()).isEqualTo(name);
        assertThat(john_doe.getRole()).isEqualTo(role);
        assertThat(john_doe).isEqualTo(new Employee(id, name, role));
    }


}