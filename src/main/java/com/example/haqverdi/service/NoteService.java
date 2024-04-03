package com.example.haqverdi.service;

import com.example.haqverdi.dto.NoteDto;


import java.util.List;
import java.util.Optional;

public interface NoteService {

    List<NoteDto> findAll();

    NoteDto save(NoteDto noteDto);

    NoteDto update (int id,NoteDto noteDto);


    void delete(int id);
}
