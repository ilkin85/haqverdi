package com.example.haqverdi.controller;

import com.example.haqverdi.dto.NoteDto;
import com.example.haqverdi.entity.Note;
import com.example.haqverdi.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public List<NoteDto> getAllNotes(){
        return noteService.findAll() ;
    }

    @PostMapping
    public NoteDto createNote(@RequestBody NoteDto noteDto) {
        return noteService.save(noteDto);
    }

    @PutMapping("/{id}")
    public NoteDto updateNote(@PathVariable int id , @RequestBody NoteDto noteDto) {

        return noteService.update(id,noteDto);
    }

   /* @PutMapping("/{id}")
    public NoteDto updateCheckStatus(@PathVariable int id,@RequestParam boolean checked) {

        return noteService.updateCheck(id,checked);

    }*/

    @DeleteMapping("{id}")
    public void  deleteNote(@PathVariable int id) {

        noteService.delete(id);

    }

}
