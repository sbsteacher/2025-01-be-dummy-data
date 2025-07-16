package com.green.dummydata.feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedPostReq {
    private long writerUserId;
    private String contents;
    private String location;
}
