package org.hyunsworld.service;

import java.util.List;

import javax.inject.Inject;

import org.hyunsworld.domain.Criteria;
import org.hyunsworld.domain.ReplyVO;
import org.hyunsworld.persistence.ReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Inject
    private ReplyDAO dao;
    
    @Override
    public void addReply(ReplyVO vo) throws Exception {
        dao.create(vo);
    }

    @Override
    public List<ReplyVO> listReply(int bno) throws Exception {
        return dao.list(bno);
    }

    @Override
    public void modifyReply(ReplyVO vo) throws Exception {
        dao.update(vo);
    }

    @Override
    public void removeReply(int rno) throws Exception {
        dao.delete(rno);
    }

    @Override
    public List<ReplyVO> listReplyPage(int bno, Criteria cri) throws Exception {
        return dao.listPage(bno, cri);
    }

    @Override
    public int count(int bno) throws Exception {
        return dao.count(bno);
    }

}
