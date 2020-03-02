package com.mangostreet.mangostreetserspring.service.impl;

import com.mangostreet.mangostreetserspring.dataobject.Note;
import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.dto.TokenDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceImplTest {

    @Autowired
    private NoteServiceImpl noteService;

    @Test
    public void addNote() throws Exception {
        Note note = noteService.addNote("123","2","3","4");
//        Assert.assertEquals("ztzt", user.getUserId());
    }
}