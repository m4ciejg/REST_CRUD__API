package com.maciejg.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maciejg.CRUD.EntityNote;
@Repository
public interface NoteRepository  extends JpaRepository<EntityNote, Long>{

}
