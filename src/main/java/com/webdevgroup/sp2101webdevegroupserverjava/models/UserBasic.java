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
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String userName;
    private String email;
    private String type;

}
