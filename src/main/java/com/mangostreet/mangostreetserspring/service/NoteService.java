package com.mangostreet.mangostreetserspring.service;

import com.mangostreet.mangostreetserspring.dataobject.Note;

public interface NoteService {
    Note addNote(String noteType,String noteTitle,String noteDescription,String noteContent);
}
