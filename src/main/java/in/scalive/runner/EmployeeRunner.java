package in.scalive.runner;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Employee;
import in.scalive.services.EmployeeService;
@Component
public class EmployeeRunner implements CommandLineRunner {
	private EmployeeService employeeService;
	
     @Autowired
	public EmployeeRunner(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner scanner =new Scanner(System.in);
		int choice;
		do {
			System.out.println("Select An operation ?");
		  	System.out.println("1.Add Employee");
			System.out.println("2.View All Employee");
			System.out.println("3.Search Employee");
			System.out.println("4.update Employee");
			System.out.println("5.Delete Employee");
			System.out.println("6.Exite");
			System.out.println("Enter what do you?");
			choice=scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter a id");
			int id=scanner.nextInt();
			System.out.println("Enter a name");
			String nameString=scanner.next();
			System.out.println("Enter a deparment");
			String departmentString=scanner.next();
			System.out.println("Enter a salary");
			double salary=scanner.nextDouble();
			Employee employee=new Employee();
			employee.setId(id);
			employee.setName(nameString);
			employee.setDepartment(departmentString);
			employee.setSalary(salary);
			employeeService.save(employee);
			System.out.println("Create employee Successfull..!");
			break;
		
		case 2:
			
			List<Employee> allEmployees=employeeService.findAllEmployees();
			if(allEmployees.isEmpty()) {
				System.out.println("No Employee Found");
			}else {
				for (Employee emp:allEmployees)
				{
					System.out.println(emp);
				}
			}
			
			break;
			
		
		case 3:
			System.out.println("Enter a id Search employee ?");
			int searchId=scanner.nextInt();
			 Employee searchEmployee=employeeService.findById(searchId);
			  if(searchEmployee !=null) {
				  System.out.println(searchEmployee);
			  }
			  else {
				System.out.println("No Record Found");
			}
			break;
			
		case 4: 
			
			System.out.println("Enter a id  emp");
			int updateId=scanner.nextInt();
			Employee updateEmployee=employeeService.findById(updateId);
			if(updateEmployee!=null) {
			System.out.println("Enter a update  name");
			String updateName=scanner.next();
			System.out.println("Enter a update deparment");
			String updateDepartment=scanner.next();
			System.out.println("Enter a update salary");
			double updateSalary=scanner.nextDouble();
			updateEmployee.setName(updateName);
			updateEmployee.setDepartment(updateDepartment);
			updateEmployee.setSalary(updateSalary);
			employeeService.update(updateEmployee);
			}
			else {
				System.out.println("No Reacord updated!!");
			}
			
			break;
		case 5:
			System.out.println("Enter a id delete emp ?");
			int deleteId=scanner.nextInt();
			int count =employeeService.delete(deleteId);
			if(count==0) {
				System.out.println("No Record Delete");
			}
			else {
				System.out.println("Record delete!!");
			}
			break;
		case 6:
			System.out.println("Thnak you !!");
			return;
		default:
			System.out.println("Wrong choice ! try again");
		}
	}while(true);
	}
 
}
