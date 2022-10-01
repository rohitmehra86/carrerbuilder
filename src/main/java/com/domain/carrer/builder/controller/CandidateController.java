package com.domain.carrer.builder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.domain.carrer.builder.entity.Candidate;
import com.domain.carrer.builder.exception.ResourceNotFoundException;
import com.domain.carrer.builder.repository.CandidateRepository;

@RestController
@RequestMapping("/api/v1/candidate")
public class CandidateController {
	@Autowired
	private CandidateRepository candidateRepository;

	@GetMapping
	public List<Candidate> getAllEmployees() {
		return candidateRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Candidate> getEmployeeById(@PathVariable(value = "id") Long candidateId)
			throws ResourceNotFoundException {
		Candidate employee = candidateRepository.findById(candidateId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping
	public Candidate createEmployee(@RequestBody Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Candidate> updateEmployee(@PathVariable(value = "id") Long candidateId,
			@RequestBody Candidate candidate) throws ResourceNotFoundException {
		candidateRepository.findById(candidateId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));

		final Candidate updatedCandidate = candidateRepository.save(candidate);
		return ResponseEntity.ok(updatedCandidate);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long candidateId)
			throws ResourceNotFoundException {
		Candidate candidate = candidateRepository.findById(candidateId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));

		candidateRepository.delete(candidate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
