package com.mangostreet.mangostreetserspring.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@DynamicUpdate
@Data
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class NoteImage {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String imageId;
    private String imageUrl;
    private String noteId;
}
