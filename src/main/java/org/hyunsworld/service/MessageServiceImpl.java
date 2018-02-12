package org.hyunsworld.service;

import javax.inject.Inject;

import org.hyunsworld.domain.MessageVO;
import org.hyunsworld.persistence.MessageDAO;
import org.hyunsworld.persistence.PointDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {
    
    @Inject
    private MessageDAO messageDAO;
    @Inject
    private PointDAO pointDAO;

    @Transactional
    @Override
    public void addMessage(MessageVO vo) throws Exception {
        messageDAO.create(vo);
        pointDAO.updatePoint(vo.getSender(), 10);
    }

    @Override
    public MessageVO readMessage(String uid, int mid) throws Exception {
        messageDAO.updateState(mid);
        pointDAO.updatePoint(uid, 5);
        return messageDAO.readMessage(mid);
    }

}
