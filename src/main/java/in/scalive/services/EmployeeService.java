package in.scalive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Employee;
import in.scalive.repository.EmployeeRepository;

@Service
public class EmployeeService {
	 private EmployeeRepository employeeRepository;
     @Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}
     public int save(Employee employee) {
    	 return employeeRepository.save(employee);
    	 
     }
     
     public int update(Employee employee) {
    	 return employeeRepository.update(employee);
    	 
     }
     
     public int delete(int id) {
    	 return employeeRepository.delete(id);
     }

     public Employee findById(int id) {
    	 return employeeRepository.findById(id);
     }
     
     public List<Employee> findAllEmployees(){
    	 return employeeRepository.findAllEmployees();
     }
}

    
