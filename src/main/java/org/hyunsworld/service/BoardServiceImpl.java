package org.hyunsworld.service;

import java.util.List;

import javax.inject.Inject;

import org.hyunsworld.domain.BoardVO;
import org.hyunsworld.domain.Criteria;
import org.hyunsworld.persistence.BoardDAO;
import org.springframework.stereotype.Service;
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(int bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

    @Override
    public List<BoardVO> listCriteria(Criteria cri) throws Exception {
        return dao.listCriteria(cri);
    }

}
