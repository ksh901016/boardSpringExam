package org.hyunsworld.controller;

import javax.inject.Inject;

import org.hyunsworld.domain.BoardVO;
import org.hyunsworld.domain.Criteria;
import org.hyunsworld.domain.PageMaker;
import org.hyunsworld.domain.SearchCriteria;
import org.hyunsworld.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
    private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
    
    @Inject
    private BoardService service;
    
    @RequestMapping(value="list", method = RequestMethod.GET)
    public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
        logger.info(cri.toString());
        
        //model.addAttribute("list", service.listCriteria(cri));
        model.addAttribute("list", service.listSearchCriteria(cri));
        
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        //pageMaker.setTotalCount(service.listCountCriteria(cri));
        pageMaker.setTotalCount(service.listSearchCount(cri));
        
        model.addAttribute("pageMaker", pageMaker);
    }
    
    @RequestMapping(value="/readPage", method = RequestMethod.GET)
    public void read(@RequestParam("bno") int bno,
                @ModelAttribute("cri") SearchCriteria cri,
                Model model) throws Exception{
        model.addAttribute(service.read(bno));
    }
    
    @RequestMapping(value="/removePage", method=RequestMethod.POST)
    public String remove(@RequestParam("bno") int bno, 
                SearchCriteria cri,
                RedirectAttributes rttr) throws Exception{
        service.remove(bno);
        rttr.addAttribute("page",cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
        rttr.addAttribute("keyword", cri.getKeyword());
        
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/sboard/list";
    }
    
    @RequestMapping(value="/modifyPage", method=RequestMethod.GET)
    public void modify(int bno,
                @ModelAttribute("cri") SearchCriteria cri,
                Model model) throws Exception{
        model.addAttribute(service.read(bno));
    }
    
    @RequestMapping(value="/modifyPage", method=RequestMethod.POST)
    public String modify(BoardVO board,
                SearchCriteria cri,
                RedirectAttributes rttr) throws Exception{
        logger.info("mod post.....");
        
        service.modify(board);
        rttr.addFlashAttribute("msg", "SUCCESS");
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
        rttr.addAttribute("keyword", cri.getKeyword());
        return "redirect:/sboard/list";
    }
    
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
        return "redirect:/sboard/list";
    }
}
