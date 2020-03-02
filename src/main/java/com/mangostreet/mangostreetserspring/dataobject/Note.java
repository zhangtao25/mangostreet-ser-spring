package com.mangostreet.mangostreetserspring.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Note {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String noteId;
    private String noteType;
    private String noteTitle;
    private String noteDescription;
    private String noteContent;
    private String userId;
}
