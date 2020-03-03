package com.mangostreet.mangostreetserspring.repository;

import com.mangostreet.mangostreetserspring.dataobject.NoteImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteImageRepository extends JpaRepository<NoteImage, String> {
}
