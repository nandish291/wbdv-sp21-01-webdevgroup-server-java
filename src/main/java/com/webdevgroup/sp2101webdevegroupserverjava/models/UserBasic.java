package com.webdevgroup.sp2101webdevegroupserverjava.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserBasic {
    private Long id;
    private String firstname;
    private String lastname;
    private Date dob;
    private String gender;
    private String username;
    private String email;
    private String type;

}
