package com.green.dummydata.user;

import com.green.dummydata.user.model.UserJoinReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int join(UserJoinReq req);
}
