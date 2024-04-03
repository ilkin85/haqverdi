package com.example.haqverdi.service.lmpl;

import com.example.haqverdi.dto.NoteDto;
import com.example.haqverdi.entity.Note;
import com.example.haqverdi.mapper.NoteMapper;
import com.example.haqverdi.mapper.NoteMapperImpl;
import com.example.haqverdi.repository.NoteRepository;
import com.example.haqverdi.service.NoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final NoteMapperImpl noteMapper;

    @Override
    public List<NoteDto> findAll(){
        List<Note> all = noteRepository.findAll();
        /*return all.stream()
                .map(noteMapper::toDto)
                .collect(Collectors.toList());*/
        return noteRepository.findByStatus(true).stream().map(noteMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public NoteDto save(NoteDto noteDto) {

        return noteMapper.toDto(noteRepository.save(noteMapper.toEntity(noteDto)));
    }

//    {text:gvchc, checked:true}

    @Override
    public NoteDto update(int id, NoteDto noteDto) {
        Note note = noteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Player by id :" + id + "not found"));

//if(note.ischecked != obj.checked && (obj.checked == true || obj.checked.checked == false)) note.set
       /*note.setChecked(noteDto.isChecked());*/

        if (noteDto.getText() != null && !noteDto.getText().isEmpty()) {
            note.setText(noteDto.getText());
        }





        Note save = noteRepository.save(note);
        return noteMapper.toDto(save);

    }

  /*  @Override
    public NoteDto updateCheck(int id, boolean checked) {
        Note note = noteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Player by id :" + id + "not found"));

        note.setChecked(checked);

        Note save = noteRepository.save(note);
        return noteMapper.toDto(save);
    }*/

   /* @Override
    public void deleteById(int id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Player by id :" + id + "not found"));
        noteRepository.delete(note);

        return "Deleted th id-" +id;
    }*/

    @Override
    @Transactional
    public void delete(int id){
        Note note = noteRepository.findByIdAndStatus(id,true)
                .orElseThrow(()->new RuntimeException("Note by id:" + id + "not found"));
        note.setStatus(false);
        noteRepository.save(note);
    }


}
