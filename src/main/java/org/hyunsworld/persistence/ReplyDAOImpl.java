package org.hyunsworld.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hyunsworld.domain.Criteria;
import org.hyunsworld.domain.ReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
    
    @Inject
    private SqlSession sqlSession;
    
    private static final String namespace = "org.hyunsworld.mapper.ReplyMapper";
    
    @Override
    public void create(ReplyVO vo) throws Exception {
        sqlSession.insert(namespace+".create", vo);
    }

    @Override
    public List<ReplyVO> list(int bno) throws Exception {
        return sqlSession.selectList(namespace+".list", bno);
    }

    @Override
    public void update(ReplyVO vo) throws Exception {
        sqlSession.update(namespace+".update", vo);
    }

    @Override
    public void delete(int rno) throws Exception {
        sqlSession.delete(namespace+".delete", rno);
    }

    @Override
    public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
        Map<String,Object> paramMap = new HashMap<String, Object>();
        
        paramMap.put("bno", bno);
        paramMap.put("cri", cri);
        
        return sqlSession.selectList(namespace+".listPage", paramMap);
    }

    @Override
    public int count(int bno) throws Exception {
        return sqlSession.selectOne(namespace+".count", bno);
    }

}
