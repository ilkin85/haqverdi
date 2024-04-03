package com.example.haqverdi.mapper;

public interface NoteMapper <N,N1>{
    N1 toDto(N n);
    N toEntity(N1 n1);
}
