package com.mangostreet.mangostreetserspring.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
public class Userinfo {
    @Id
    private String userinfoId;
    private String userinfoGender;
    private String userinfoBirthday;
    private String userId;
}
