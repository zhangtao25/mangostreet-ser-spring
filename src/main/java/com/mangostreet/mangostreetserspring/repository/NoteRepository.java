package com.mangostreet.mangostreetserspring.repository;

import com.mangostreet.mangostreetserspring.dataobject.Note;
import com.mangostreet.mangostreetserspring.dataobject.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, String> {
}
