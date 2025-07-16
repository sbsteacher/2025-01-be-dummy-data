package com.green.dummydata.user;

import com.green.dummydata.Dummy;
import com.green.dummydata.user.model.UserJoinReq;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

class UserDummy extends Dummy {

    final int ADD_ROW_COUNT = 1000;

    @Test
    void generate() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        for(int i = 0; i < ADD_ROW_COUNT; i++) {
            String uid = enFaker.internet().emailAddress();
            if(uid.length() > 30) {
                uid = uid.substring(0, 30);
            }
            UserJoinReq req = new UserJoinReq();
            req.setNickName(koFaker.funnyName().name());
            req.setUid(uid);
            req.setUpw(enFaker.internet().password());
            req.setPic("default.jpg");
            System.out.println("req: " + req);

            userMapper.join(req);
            sqlSession.flushStatements();
        }

    }

}