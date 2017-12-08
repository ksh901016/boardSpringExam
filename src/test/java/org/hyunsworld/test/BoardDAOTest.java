package org.hyunsworld.test;

import java.util.List;

import javax.inject.Inject;

import org.hyunsworld.domain.BoardVO;
import org.hyunsworld.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	//@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user00");
		dao.create(board);
	}
	//@Test
	public void testRead() throws Exception {
	    List<BoardVO> list = dao.listAll();
	    for(BoardVO result : list) {
	        logger.info(result.toString());
	    }
	}
	//@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("제목을 수정합니다.");
		board.setContent("내용을 수정합니다.");
		dao.update(board);
	}
	
	//@Test
	public void testDelete() throws Exception{
		dao.delete(2);
		dao.delete(3);
		dao.delete(4);
		dao.delete(5);
	}
	
	//@Test
	public void testListPage() throws Exception{
	    int page = 3;
	    List<BoardVO> list = dao.listPage(page);
	    
	    for(BoardVO boardVO : list) {
	        logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
	    }
	}
	
	@Test
	public void testURI() throws Exception{
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	            .path("/board/read")
	            .queryParam("bno", 12)
	            .queryParam("perPageNum", 20)
	            .build();
	    
	    logger.info(uriComponents.toString());
	}
}
