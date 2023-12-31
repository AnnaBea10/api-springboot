package com.example.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.entities.Employee;
import com.example.api.services.EmployeeService;

@RestController
@RequestMapping(value = "/employeers")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity <List<Employee>> findAll() {
		List<Employee> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		Employee obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Insert
	@PostMapping
	public ResponseEntity<Employee> insert(@RequestBody Employee obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	//Delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Update
	@PutMapping(value = "/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
