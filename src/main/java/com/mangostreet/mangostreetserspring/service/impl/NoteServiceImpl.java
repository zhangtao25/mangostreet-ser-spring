package com.mangostreet.mangostreetserspring.service.impl;

import com.mangostreet.mangostreetserspring.dataobject.Note;
import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.repository.NoteRepository;
import com.mangostreet.mangostreetserspring.repository.UserRepository;
import com.mangostreet.mangostreetserspring.repository.UserinfoRepository;
import com.mangostreet.mangostreetserspring.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note addNote(String noteType, String noteTitle, String noteDescription, String noteContent) {
        Note note = new Note();
//        note.setNoteId("3");
        note.setNoteType(noteType);
        note.setNoteDescription(noteDescription);
        note.setNoteContent(noteContent);
        note.setUserId("4");
        note.setNoteTitle(noteTitle);
        return noteRepository.save(note);
    }
}
