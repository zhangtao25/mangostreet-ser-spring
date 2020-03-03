package com.mangostreet.mangostreetserspring.service.impl;

import com.mangostreet.mangostreetserspring.dataobject.NoteImage;
import com.mangostreet.mangostreetserspring.repository.NoteImageRepository;
import com.mangostreet.mangostreetserspring.service.NoteImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteImageServiceImpl implements NoteImageService {

    @Autowired
    private NoteImageRepository noteImageRepository;

    @Override
    public NoteImage addNoteImage(String imageUrl, String noteId) {
        NoteImage noteImage = new NoteImage();
        noteImage.setImageUrl(imageUrl);
        noteImage.setNoteId(noteId);
        noteImageRepository.save(noteImage);
        return null;
    }
}
