package nl.paulzijlmans.springboot.thymeleafdemo.service;

import lombok.AllArgsConstructor;
import nl.paulzijlmans.springboot.thymeleafdemo.dao.EmployeeRepository;
import nl.paulzijlmans.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee id not found - " + id));
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.delete(findById(id));
    }
}
