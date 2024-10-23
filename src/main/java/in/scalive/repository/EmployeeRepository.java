package in.scalive.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.scalive.model.Employee;
@Repository
public class EmployeeRepository {
	private JdbcTemplate jdbcTemplate;
	

	public EmployeeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Employee employee) {
		String sqlString="insert into employees values(?,?,?,?)";
		return jdbcTemplate.update(sqlString, employee.getId(), employee.getName(), employee.getDepartment(), employee.getSalary());
		
	}
	public int update(Employee employee) {
		String sqlString="update employees set name=?, department=?, salary=? where id=?";
		return jdbcTemplate.update(sqlString, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
		
	}
	public int delete(int id) {
		String sqlString="delete from employees where id=?";
		return jdbcTemplate.update(sqlString,id);
		
	}
	public Employee findById(int id){
		Employee employee=null;
		String sqlString="select * from employees where id=?";
		try {
		employee=jdbcTemplate.queryForObject(sqlString,new EmployeeRowMapper(),id);
		}catch (DataAccessException e) {
			System.out.println("Error"+e.getMessage());
		}
		finally {
			return employee;
		}
		
	}
	
	public List<Employee> findAllEmployees() {
		String sqlString ="select * from employees";
		List< Employee> employees=jdbcTemplate.query(sqlString, new EmployeeRowMapper());
		return employees;
		
	}
	
	
	
}