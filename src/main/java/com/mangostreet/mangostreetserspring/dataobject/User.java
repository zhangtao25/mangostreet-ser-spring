package com.mangostreet.mangostreetserspring.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
public class User {

    @Id
    private String userId;
    private String userToken;
    private String userPhone;
    private String userEmail;
    private String userPassword;
    private String userNikename;
}
