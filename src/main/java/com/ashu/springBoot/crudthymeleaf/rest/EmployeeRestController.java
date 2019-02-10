package com.ashu.springBoot.crudthymeleaf.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashu.springBoot.crudthymeleaf.entity.Employee;
import com.ashu.springBoot.crudthymeleaf.service.EmployeeService;


@Controller
@RequestMapping("employees")
public class EmployeeRestController {

	private List<Employee> listOfEmployees;
	
	private EmployeeService empService;
	public EmployeeRestController(EmployeeService theEmployeeService){
		this.empService = theEmployeeService;
	}
	
	@GetMapping("/start")
	public String start(Model model){
		
		model.addAttribute("Date", LocalDateTime.now());
		
		return "Hello";
	}
	
	/*@PostConstruct
	public void loadata(){
		
		Employee emp = new Employee("Ashu", "CTS", "as@as.com");
		Employee emp1 = new Employee("Sid", "CTS", "sid@as.com");
		Employee emp2 = new Employee("Tarun", "CTS", "tr@as.com");
		
		listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(emp);
		listOfEmployees.add(emp1);
		listOfEmployees.add(emp2);
		
	}*/
	
	@GetMapping("/list")
	public String displayEmployeeList(Model model){
		listOfEmployees = empService.findAll();
		model.addAttribute("empList",listOfEmployees);
		
		return "Employee-List";
	}
	
	@GetMapping("/showFormForAdd")
	public String displayForm(Model model){
		
		//create a model attribute to bind the Form data
		Employee employee = new Employee();
		model.addAttribute("theEmployee", employee);
		return "employee-form"; 
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("theEmployee") Employee theEmployee){
		empService.add(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showForForUpdate(@RequestParam("employeeID") int id, Model model){
		Employee employee = empService.findById(id);
		model.addAttribute("theEmployee", employee);
		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeID") int id){
		empService.deleteById(id);
		return "redirect:/employees/list";
	}
}
