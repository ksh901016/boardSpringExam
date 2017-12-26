package org.hyunsworld.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hyunsworld.domain.MessageVO;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Inject
    private SqlSession sqlSession;
    
    private static final String namespace = "org.hyunsworld.mapper.MessageMapper";
    
    @Override
    public void create(MessageVO vo) throws Exception {
        sqlSession.insert(namespace+".create", vo);
    }

    @Override
    public MessageVO readMessage(int mid) throws Exception {
        return sqlSession.selectOne(namespace+".readMessage", mid);
    }

    @Override
    public void updateState(int mid) throws Exception {
        sqlSession.update(namespace+".updateState", mid);
    }

}
