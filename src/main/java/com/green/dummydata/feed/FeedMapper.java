package com.green.dummydata.feed;

import com.green.dummydata.feed.model.FeedPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int save(FeedPostReq req);
}
