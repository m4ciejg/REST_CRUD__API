package com.maciejg.CRUD.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.CRUD.EntityNote;
import com.maciejg.CRUD.exception.ResourceNotFoundException;
import com.maciejg.CRUD.repository.NoteRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NoteController {
	
	@Autowired
	NoteRepository noteRepository;

	@GetMapping("/notes")
	public List<EntityNote> getAll(){
		
		return noteRepository.findAll();
	}
	
	@PostMapping("/notes")
	public EntityNote createm(@Valid @RequestBody EntityNote entityNote) {
		
		return noteRepository.save(entityNote);
	}

	@GetMapping("/notes/{id}")
	public EntityNote getNoteById(@PathVariable(value = "id") Long id) {
	    return noteRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}
	
	@PutMapping("/notes/{id}")
	public EntityNote update(@PathVariable(value = "id") long id,
							@Valid @RequestBody EntityNote noteDetails ) {
		
		EntityNote entityNote = noteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("EntityNote", "id", id));
		
		entityNote.setTitle(noteDetails.getTitle());
		entityNote.setAuthor(noteDetails.getAuthor());
		entityNote.setContent(noteDetails.getContent());
		
		EntityNote updated = noteRepository.save(entityNote);
		
		return updated;
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id){
		
		EntityNote entityNote = noteRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("EntityNote", "id", id));
		
		noteRepository.delete(entityNote);
		
		return ResponseEntity.ok().build();
	}
}