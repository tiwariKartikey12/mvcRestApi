package com.example.codebase.mvcRestApi.contollers;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private EmployeeDTO employeeDTO;

//    @GetMapping
//    public String getEmployee() {
//        return "Hello GET API";
//    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return new EmployeeDTO(employeeId, "Kartikey", "kartikeytiwari@brave.com", 25, LocalDate.now(), true);
    }

    @GetMapping
    public String getEmployeeByNameOrAge(@RequestParam(required = false, name = "name") String nameOfEmployee, @RequestParam(required = false) Integer age) {
        return "Hi " + nameOfEmployee + ",your age is " + age;
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(76L);
        return employeeDTO;
    }

    @PutMapping
    public String updateEmployee() {
        return "Hello from PUT";
    }

}
