package com.green.dummydata.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserJoinReq {
    private String uid;
    private String upw;
    private String nickName;
    private String pic;
}
