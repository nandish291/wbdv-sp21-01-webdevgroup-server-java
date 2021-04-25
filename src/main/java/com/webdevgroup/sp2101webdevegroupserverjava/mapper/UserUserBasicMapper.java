package com.webdevgroup.sp2101webdevegroupserverjava.mapper;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.models.UserBasic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserUserBasicMapper {
    UserBasic UserToUserBasic(User user);

    List<UserBasic> UserToUserBasicSet(List<User> users);
}
