package com.mangostreet.mangostreetserspring.controller;

import com.mangostreet.mangostreetserspring.VO.ResultVO;
import com.mangostreet.mangostreetserspring.dataobject.Note;
import com.mangostreet.mangostreetserspring.form.NoteForm;
import com.mangostreet.mangostreetserspring.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public ResultVO add (@RequestBody NoteForm jsonParam){


        String noteType = jsonParam.getNoteType();
        String noteContent = jsonParam.getNoteContent();
        String noteDescription = jsonParam.getNoteDescription();
        String noteTitle = jsonParam.getNoteTitle();


        Note note = noteService.addNote(noteType,noteTitle,noteDescription,noteContent);


        return null;
    }
}
