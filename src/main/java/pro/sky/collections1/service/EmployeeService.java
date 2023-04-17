package pro.sky.collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.collections1.exception.EmployeeAlreadyAddedException;
import pro.sky.collections1.exception.EmployeeNotFoundException;
import pro.sky.collections1.exception.EmployeeStorageIsFullException;
import pro.sky.collections1.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private static final int SIZE = 3;
    private final List<Employee> employees = new ArrayList<>(SIZE);

    public Employee add(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.size() < SIZE) {
            for (Employee emp : employees) {
                if (employee.equals(emp)) {
                    throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
                }

            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException("Массив переполнен");
    }


    public Employee find(String lastName, String firstName) {
        Employee emp = new Employee(lastName, firstName);
        if (employees.contains(emp)) {
            return emp;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }



    public Employee remove(String lastName, String firstName) {
        Employee emp = new Employee(lastName, firstName);
        if (employees.remove(emp)) {
            return emp;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }
}


