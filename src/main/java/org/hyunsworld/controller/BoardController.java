package org.hyunsworld.controller;

import javax.inject.Inject;

import org.hyunsworld.domain.BoardVO;
import org.hyunsworld.domain.Criteria;
import org.hyunsworld.domain.PageMaker;
import org.hyunsworld.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception{
		logger.info("register get....");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		logger.info("regist post .....");
		logger.info(board.toString());
		
		service.regist(board);
		
		//model.addAttribute("result", "success")
		rttr.addFlashAttribute("msg", "success");
		
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	//@RequestMapping(value="/listAll", method=RequestMethod.GET)
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception{
		logger.info("show all list........");
		//model.addAttribute("list", service.listAll());
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
    public void read(@RequestParam("bno") int bno, Model model) throws Exception{
	    // 아무런 이름 없이 데이터를 넣으면 자동으로 클래스의 이름을 소문자로 시작해서 사용(boardVO)
        model.addAttribute(service.read(bno));
    }
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
	    service.remove(bno);
	    rttr.addFlashAttribute("msg", "SUCCESS");
	    return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
    public void modify(int bno, Model model) throws Exception{
	    model.addAttribute(service.read(bno));
    }
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
    public String modify(BoardVO board, RedirectAttributes rttr) throws Exception{
	    logger.info("mod post.....");
	    
	    service.modify(board);
	    rttr.addFlashAttribute("msg", "SUCCESS");
	    return "redirect:/board/listAll";
    }
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception{
	    logger.info(cri.toString());
	    
	    model.addAttribute("list", service.listCriteria(cri));
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    //pageMaker.setTotalCount(4097);
	    pageMaker.setTotalCount(service.listCountCriteria(cri));
	    
	    model.addAttribute("pageMaker", pageMaker);
	}
}
