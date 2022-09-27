package edu.depaul.cdm.se452.RightOfWayRentals.data.repository;

import edu.depaul.cdm.se452.RightOfWayRentals.data.model.Employee;
import edu.depaul.cdm.se452.RightOfWayRentals.data.pojo.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    final Employee employee_1 = new Employee( "John Doe", Role.SALESMAN);

    @BeforeEach
    void populate() { persistEmployee(employee_1); }

    @AfterEach
    void cleanup() { repository.deleteAll(); }

    @Test
    void givenId_willFindCorrectEmployee() {
        final Employee employee = repository.findById(1L).orElseThrow();
        assertThat(employee)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", employee_1.getName())
                .hasFieldOrPropertyWithValue("role", employee_1.getRole());
    }

    @Test
    void getAllEmployees() {
        final Employee manager = new Employee("E_MANAGER", Role.MANAGER);
        final Employee busboy = new Employee("E_BUSBOY", Role.BUSBOY);
        final List<Employee> employees = List.of(manager, busboy);
        assertThat(manager.getId()).isZero().isEqualTo(busboy.getId());

        repository.saveAll(employees);
        assertThat(repository.findAll()).hasSize(3)
                .contains(employee_1, manager, busboy);

        assertThat(manager.getId()).isEqualTo(2L);
        assertThat(busboy.getId()).isEqualTo(3L);
    }

    @Test
    void existsById() {
        assertThat(repository.existsById(1L)).isTrue();
    }

    @Test
    void updateEmployee() {
        final Employee employee = repository.findById(1L).orElseThrow();
        assertThat(employee.getRole()).isEqualTo(Role.SALESMAN);

        employee.setRole(Role.MANAGER);
        persistEmployee(employee);

        final Employee emp_updated = repository.findById(1L).orElseThrow();
        assertThat(emp_updated)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", employee_1.getName())
                .hasFieldOrPropertyWithValue("role", Role.MANAGER);
    }



    private void persistEmployee(final Employee emp) {
        repository.save(emp);
    }

}