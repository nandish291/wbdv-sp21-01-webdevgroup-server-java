package com.webdevgroup.sp2101webdevegroupserverjava.mapper;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.models.UserBasic;
import org.mapstruct.Mapper;

@Mapper
public interface UserUserBasicMapper {
    UserBasic UserToUserBasic(User user);
}
