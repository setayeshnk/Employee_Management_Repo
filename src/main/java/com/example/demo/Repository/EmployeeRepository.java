package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository <Employee , Integer> {
    Employee findEmployeeByName(String name);
    Employee findEmployeeByBirthDate(Date birthDate);

    //1
    @Query(value = "select e  from Employee e where e.name like '%s%'")
    Employee findAllByNameIsContaining();

    //2
    @Query(value = "select e from Employee e where e.name like '%d'")
    List<Employee> findAllByNameIsEndingWith();

    //3
    @Query(value = "select e from Employee e where e.name like 'v%'")
    Employee findEmployeeByNameStartingWith();

    //4
    @Query(value = "select e from Employee e where e.phone like '0933%'")
    Employee findEmployeeByPhoneStartingWith();

    //5
    @Query(value = "select e from Employee e where e.phone like '%2%'")
    Employee findEmployeeByPhoneContaining();

    @Query(value = "select e from Employee e where e.lastName like '%ی'")
    Employee findEmployeeByLastNameContaining();

    @Query(value = "select e from Employee e  order by e.birthDate ASC ")
    List<Employee> findByOrderByBirthDateAsc();

    @Query(value = "select e from Employee e order by e.name")
    List<Employee> findAllByOrderByName();
}
