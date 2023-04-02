package pro.sky.collections1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections1.model.Employee;
import pro.sky.collections1.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeServiceController {
    private final EmployeeService employeeService;

    public EmployeeServiceController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.add(lastName, firstName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.remove(lastName, firstName);

    }

    @GetMapping("/find")
    public Employee find(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.find(lastName, firstName);
    }

    @GetMapping
    public List <Employee> list() {
        return employeeService.list();
    }
}
