package com.mangostreet.mangostreetserspring.controller;

import com.mangostreet.mangostreetserspring.VO.ResultVO;
import com.mangostreet.mangostreetserspring.dataobject.Note;
import com.mangostreet.mangostreetserspring.dataobject.NoteImage;
import com.mangostreet.mangostreetserspring.form.NoteForm;
import com.mangostreet.mangostreetserspring.service.NoteImageService;
import com.mangostreet.mangostreetserspring.service.NoteService;
import com.mangostreet.mangostreetserspring.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteImageService noteImageService;

    @PostMapping("/add")
    public ResultVO add (@RequestBody NoteForm jsonParam){


        String noteType = jsonParam.getNoteType();
        String noteContent = jsonParam.getNoteContent();
        String noteDescription = jsonParam.getNoteDescription();
        String noteTitle = jsonParam.getNoteTitle();

        String imageUrl = jsonParam.getImageUrl();


        Note note = noteService.addNote(noteType,noteTitle,noteDescription,noteContent);

        NoteImage noteImage = noteImageService.addNoteImage(imageUrl,note.getNoteId());


        return ResultVOUtil.success(noteImage);
    }
}
