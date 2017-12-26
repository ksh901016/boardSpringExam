package org.hyunsworld.persistence;

import org.hyunsworld.domain.MessageVO;

public interface MessageDAO {
    public void create(MessageVO vo) throws Exception;
    public MessageVO readMessage(int mid) throws Exception;
    public void updateState(int mid) throws Exception;
}
