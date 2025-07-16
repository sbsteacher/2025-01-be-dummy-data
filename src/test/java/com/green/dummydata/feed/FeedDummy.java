package com.green.dummydata.feed;

import com.green.dummydata.Dummy;
import com.green.dummydata.feed.model.FeedPostReq;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class FeedDummy extends Dummy {

    final int ADD_ROW_COUNT = 10_000;

    @Test
    void generate() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        FeedMapper feedMapper = sqlSession.getMapper(FeedMapper.class);

        for(int i = 0; i < ADD_ROW_COUNT; i++) {
            FeedPostReq req = new FeedPostReq();
            long userId = koFaker.random().nextInt(1, 1066);
            req.setWriterUserId(userId);
            req.setContents(koFaker.emoji().cat());
            req.setLocation(koFaker.location().nature());
            feedMapper.save(req);
            sqlSession.flushStatements();
        }
    }
}
