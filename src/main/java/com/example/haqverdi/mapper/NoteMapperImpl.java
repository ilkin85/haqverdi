package com.example.haqverdi.mapper;

import com.example.haqverdi.dto.NoteDto;
import com.example.haqverdi.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapperImpl implements NoteMapper<Note, NoteDto> {
    @Override
    public NoteDto toDto(Note note) {
        NoteDto noteDto =new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setText(note.getText());
        /*noteDto.setChecked(note.isChecked());*/
        return noteDto;
    }

    @Override
    public Note toEntity(NoteDto noteDto) {
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setText(noteDto.getText());
        /*note.setChecked(noteDto.isChecked());*/
        return note;
    }
}
