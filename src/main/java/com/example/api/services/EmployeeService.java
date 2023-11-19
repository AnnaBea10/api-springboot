package com.example.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.entities.Employee;
import com.example.api.repositories.EmployeeRepository;
import com.example.api.services.exceptions.DatabaseException;
import com.example.api.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> findAll(){
		return repository.findAll();
	}

	public Employee findById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Employee insert(Employee obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Employee update(Long id, Employee obj) {
		try {
			Employee entity = repository.getReferenceById(id);
		    updateData(entity, obj);
		    return repository.save(entity);
		}catch (EntityNotFoundException e) {
			}throw new ResourceNotFoundException(id);
	}
		
	private void updateData(Employee entity, Employee obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
