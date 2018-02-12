package org.hyunsworld.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hyunsworld.domain.BoardVO;
import org.hyunsworld.domain.Criteria;
import org.hyunsworld.domain.SearchCriteria;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.hyunsworld.mapper.BoardMapper";
	@Override
	public void create(BoardVO vo) throws Exception {
		sqlSession.insert(namespace+".create", vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update(namespace+".update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList(namespace+".listAll");
	}

    @Override
    public List<BoardVO> listPage(int page) throws Exception {
        if(page <= 0) {
            page = 1;
        }
        page = (page-1) * 10;
        return sqlSession.selectList(namespace+".listPage", page);
    }

    @Override
    public List<BoardVO> listCriteria(Criteria cri) throws Exception {
        return sqlSession.selectList(namespace+".listCriteria", cri);
    }

    @Override
    public int countPaging(Criteria cri) throws Exception {
        return sqlSession.selectOne(namespace+".countPaging", cri);
    }

    @Override
    public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
        return sqlSession.selectList(namespace+".listSearch", cri);
    }

    @Override
    public int listSearchCount(SearchCriteria cri) throws Exception {
        return sqlSession.selectOne(namespace+".listSearchCount", cri);
    }

    @Override
    public void updateReplyCnt(int bno, int amount) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bno", bno);
        paramMap.put("amount", amount);
        
        sqlSession.update(namespace+".updateReplyCnt", paramMap);
    }

    @Override
    public void updateViewCnt(int bno) throws Exception {
        sqlSession.update(namespace+".updateViewCnt", bno);
    }

}
