package kr.hu.app.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.Criteria;
import kr.hu.app.bean.PageMaker;
import kr.hu.app.bean.UserBean;
import kr.hu.app.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
		
		@Autowired
		private BoardService boardService;
		
		@RequestMapping(value = "list", method = RequestMethod.GET)
		public String list(Model model, Criteria cri) throws Exception{

			model.addAttribute("list", boardService.listPage(cri));
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(boardService.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
			return "board/list";
		}

		@RequestMapping(value = "write", method = RequestMethod.GET)
		public String BoardWriteForm() {

			return "board/writeform";
		}
		
		@RequestMapping(value = "lookup", method = RequestMethod.GET)
		public String read(BoardBean bb, Model model) throws Exception{
			
			model.addAttribute("read", boardService.read(bb.getBoard_no()));
			
			return "board/readview";
		}
		
		@RequestMapping(value = "rewrite", method = RequestMethod.GET)
		public String update(BoardBean bb, Model model) throws Exception{
			
			model.addAttribute("update", boardService.read(bb.getBoard_no()));
			
			return "board/rewriteform";
		}
		
		@RequestMapping(value = "update", method = RequestMethod.POST)
		public String update(BoardBean bb) throws Exception{
			
			boardService.update(bb);
			
			return "redirect:/board/list";
		}
		
		@RequestMapping(value = "delete", method = RequestMethod.POST)
		public String delete(BoardBean bb) throws Exception{
			
			boardService.delete(bb.getBoard_no());
			
			return "redirect:/board/list";
		}
		@RequestMapping(value = "write", method = RequestMethod.POST)
		public String boardwrite(BoardBean bb, HttpSession session) {
			UserBean ub = (UserBean) session.getAttribute("loginuser"); String boardId =
			ub.getName(); bb.setUser_no(boardId);
			bb.setContent(bb.getContent().replaceAll("\r\n", "<br>"));
			boardService.setWrite(bb);
			return "redirect:list";
		}
}		