package com.example.demo.Controller;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    //show all of employees
    @GetMapping("/all")
    public List<Employee> AllEmployee() {
        return employeeService.findAllEmployee();
    }

    //add a new employee
    @PostMapping("/add")
    public void addEmployee(@RequestBody @Valid Employee employee) {
        employeeService.saveEmployee(employee);
    }

    //update data of an employee
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        Employee existEmployee = employeeService.get(id);
        employeeService.saveEmployee(employee);
        if (existEmployee != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //delete an employee
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    //show employee by a special name
    @GetMapping("/searchByName")
    public ResponseEntity<Employee> findEmployeeByName(@RequestParam String name) {
        Employee employee = employeeService.findEmployeeByName(name);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //show employee by a special birthdate
    @GetMapping("/searchByBirthDate")
    public ResponseEntity<Employee> findEmployeeByBirthDate(@RequestParam Date birthDate) {
        Employee employee = employeeService.findEmployeeByBirthData(birthDate);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //1-show employee that has 's' in its name
    @ResponseBody
    @GetMapping("/nameSContain")
    public ResponseEntity<Employee> searchEmployeeContain() {
        Employee employee = employeeService.findEmployeeByNameContaining();
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //2-show employee that name ends with 'd'
    @ResponseBody
    @GetMapping("/nameEndD")
    public ResponseEntity<Employee> searchEmployeeEnding() {
        Employee employee =employeeService.findEmployeeByNameEnding();
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //3-show employee that name starts with 'v'
    @ResponseBody
    @GetMapping("/nameStartV")
    public ResponseEntity<Employee> searchEmployeeStarting() {
        Employee employee = employeeService.findEmployeeByNameStarting();
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //4-show employee that phone starts with '0933'
    @ResponseBody
    @GetMapping("/phoneStart")
    public ResponseEntity<Employee> searchEmployeePhoneStart() {
        Employee employee = employeeService.findEmployeeByPhoneStarting();
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //5-show employee that phone contains '2'
//    @ResponseBody
//    @GetMapping("/phoneContain")
//    public ResponseEntity<Employee> searchEmployeePhoneContain() {
//        Employee employee = employeeService.findEmployeeByPhoneContaining() ;
//        if (employee != null) {
//            return new ResponseEntity<>(employee, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }

    //show employee that lastName contains 'ی'
    @ResponseBody
    @GetMapping("/searchLastNameContain")
    public ResponseEntity<Employee> searchEmployeeLastNameContain(@RequestParam String lastName) {
        Employee employee = employeeService.findEmployeeByLastNameContaining(lastName);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //sort employees order by birth date ascending
    @ResponseBody
    @GetMapping("/sortByBirthDate")
    public ResponseEntity<Employee> sortEmployeesByBirthDate(@RequestParam Date birthDate){
        Employee employee=employeeService.showEmployeeOrderByBirthDate(birthDate);
        if (employee!=null){
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //sort employees order by name abc...
    @GetMapping("/nameSort")
    public ResponseEntity<Employee> sortEmployeesByName(@RequestParam String name){
        Employee employee=employeeService.showEmployeeOrderByName(name);
        if (employee!=null){
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

