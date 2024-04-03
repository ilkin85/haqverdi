package com.example.haqverdi.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;
   @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean status;
}
