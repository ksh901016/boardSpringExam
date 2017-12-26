package org.hyunsworld.service;

import org.hyunsworld.domain.MessageVO;

public interface MessageService {
    public void addMessage(MessageVO vo) throws Exception;
    public MessageVO readMessage(String uid, int mid) throws Exception;
}
