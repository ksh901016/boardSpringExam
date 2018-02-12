package org.hyunsworld.persistence;

import java.util.List;

import org.hyunsworld.domain.BoardVO;
import org.hyunsworld.domain.Criteria;
import org.hyunsworld.domain.SearchCriteria;

public interface BoardDAO {
	public void create(BoardVO vo) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> listPage(int page) throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri) throws Exception;
	// 검색조건 추가 
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
	public void updateReplyCnt(int bno, int amount) throws Exception;
	public void updateViewCnt(int bno) throws Exception;
}
