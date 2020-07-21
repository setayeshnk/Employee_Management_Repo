package com.example.demo.Services;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee get(Integer id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }


    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findEmployeeByName(String name) {
        try {
            Employee employeeToFind = employeeRepository.findEmployeeByName(name);
            if (employeeToFind == null) {
                return new Employee();
            }
            return employeeToFind;
        } catch (Exception e) {
            return null;
        }
    }

    public Employee findEmployeeByBirthData(Date birthDate) {
        try {
            Employee employeeToFind = employeeRepository.findEmployeeByBirthDate(birthDate);
            if (employeeToFind == null) {
                return new Employee();
            }
            return employeeToFind;
        } catch (Exception e) {
            return null;
        }
    }

    //service 1
    public Employee findEmployeeByNameContaining() {
        try {
            Employee employee = employeeRepository.findAllByNameIsContaining();
            if (employee == null) {
                return new Employee();
            }
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    //service 2
    public Employee findEmployeeByNameEnding() {
        try {
            List<Employee> employee = employeeRepository.findAllByNameIsEndingWith();
            if (employee == null) {
                return new Employee();
            }
            return (Employee)employee;
        } catch (Exception e) {
            return null;
        }
    }

    //service 3
    public Employee findEmployeeByNameStarting() {
        try {
            Employee employee = employeeRepository.findEmployeeByNameStartingWith();
            if (employee == null) {
                return new Employee();
            }
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    //service 4
    public Employee findEmployeeByPhoneStarting() {
        try {
            Employee employee = employeeRepository.findEmployeeByPhoneStartingWith();
            if (employee == null) {
                return new Employee();
            }
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    //service 5
    public Employee findEmployeeByPhoneContaining(String phone) {
        try {
            Employee employee = employeeRepository.findEmployeeByPhoneContaining();
            if (employee == null) {
                return new Employee();
            }
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    //service 6
    public Employee findEmployeeByLastNameContaining(String lastName) {
        try {
            Employee employee = employeeRepository.findEmployeeByLastNameContaining();
            if (employee == null) {
                return new Employee();
            }
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    //service 7
    public Employee showEmployeeOrderByBirthDate(Date birthDate) {
        try {
            List<Employee> employee = employeeRepository.findByOrderByBirthDateAsc();
            if (employee == null) {
                return new Employee();
            }
            return (Employee) employee;
        } catch (Exception e) {
            return null;
        }

    }

    //service 8
    public Employee showEmployeeOrderByName(String name){
        try {
            List<Employee> employee = employeeRepository.findAllByOrderByName();
            if (employee == null) {
                return new Employee();
            }
            return (Employee) employee;
        } catch (Exception e) {
            return null;
        }

    }
}

