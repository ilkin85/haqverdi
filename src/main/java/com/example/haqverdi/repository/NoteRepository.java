package com.example.haqverdi.repository;

import com.example.haqverdi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note,Integer> {
    List<Note> findByStatus(Boolean status);

    Optional<Note> findByIdAndStatus(int id,Boolean status);
}
