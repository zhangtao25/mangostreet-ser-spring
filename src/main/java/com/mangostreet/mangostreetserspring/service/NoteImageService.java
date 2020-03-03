package com.mangostreet.mangostreetserspring.service;

import com.mangostreet.mangostreetserspring.dataobject.Note;
import com.mangostreet.mangostreetserspring.dataobject.NoteImage;

public interface NoteImageService {
    NoteImage addNoteImage(String imageUrl, String noteId);
}
