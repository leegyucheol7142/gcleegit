package kr.hu.app.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.hu.app.bean.BoardBean;
import kr.hu.app.bean.PageBean;
import kr.hu.app.bean.ReplyBean;
import kr.hu.app.bean.SearchBean;
import kr.hu.app.bean.UserBean;
import kr.hu.app.service.BoardService;
import kr.hu.app.service.ReplyService;

@Controller
@RequestMapping("/board")
public class BoardController {
		
		@Autowired
		@Qualifier("boardService")
		private BoardService boardService;
		
		@Autowired
		@Qualifier("replyService")
		private ReplyService replyService;
		
		@RequestMapping(value = "list", method = RequestMethod.GET)
		public String list(Model model, @ModelAttribute("sb") SearchBean sb) throws Exception{

			model.addAttribute("list", boardService.listPage(sb));
			
			PageBean pb = new PageBean();
			pb.setCri(sb);
			pb.setTotalCount(boardService.listCount(sb));
			
			model.addAttribute("pageBean", pb);
			return "board/list";
		}

		@RequestMapping(value = "write", method = RequestMethod.GET)
		public String BoardWriteForm() {

			return "board/writeform";
		}
		
		@RequestMapping(value = "lookup", method = RequestMethod.GET)
		public String read(BoardBean bb, Model model, SearchBean sb) throws Exception{
			
			model.addAttribute("read", boardService.read(bb.getBoard_no()));
			List<ReplyBean> replyList = replyService.readReply(bb.getBoard_no());
			model.addAttribute("replyList", replyList);
			model.addAttribute("sb", sb);
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
		
		//¥Ò±€ ¿€º∫
		@RequestMapping(value="/replyWrite", method = RequestMethod.POST)
		public String replyWrite(ReplyBean rb, SearchBean sb, RedirectAttributes rttr) throws Exception {
			System.out.println(rb);
			replyService.writeReply(rb);
			rttr.addAttribute("Board_no", rb.getBoard_no());
			rttr.addAttribute("page", sb.getPage());
			rttr.addAttribute("perPageNum", sb.getPerPageNum());
			rttr.addAttribute("searchType", sb.getSearchType());
			rttr.addAttribute("keyword", sb.getKeyword());
			
			return "redirect:/board/lookup?";
		}
		
		//¥Ò±€ ºˆ¡§ 
		@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(ReplyBean rb, SearchBean sb, Model model) throws Exception {
			
			model.addAttribute("replyUpdate", replyService.selectReply(rb.getComment_no()));
			model.addAttribute("sb", sb);
			
			return "board/replyUpdateView";
		}
		
		//¥Ò±€ ºˆ¡§ 
		@RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
		public String replyUpdate(ReplyBean rb, SearchBean sb, RedirectAttributes rttr) throws Exception {
			
			replyService.updateReply(rb);
			
			rttr.addAttribute("Board_no", rb.getBoard_no());
			rttr.addAttribute("page", sb.getPage());
			rttr.addAttribute("perPageNum", sb.getPerPageNum());
			rttr.addAttribute("searchType", sb.getSearchType());
			rttr.addAttribute("keyword", sb.getKeyword());
			
			return "redirect:/board/lookup?";
		}
		
		//¥Ò±€ ªË¡¶ 
		@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(ReplyBean rb, SearchBean sb, Model model) throws Exception {
			
			model.addAttribute("replyDelete", replyService.selectReply(rb.getBoard_no()));
			model.addAttribute("sb", sb);
			System.out.println(rb);
			System.out.println(sb);
			return "board/replyDeleteView";
		}
		
		//¥Ò±€ ªË¡¶
		@RequestMapping(value="/replyDelete", method = RequestMethod.POST)
		public String replyDelete(ReplyBean rb, SearchBean sb, RedirectAttributes rttr) throws Exception {
			
			replyService.deleteReply(rb);
			
			rttr.addAttribute("Board_no", rb.getBoard_no());
			rttr.addAttribute("page", sb.getPage());
			rttr.addAttribute("perPageNum", sb.getPerPageNum());
			rttr.addAttribute("searchType", sb.getSearchType());
			rttr.addAttribute("keyword", sb.getKeyword());
			
			return "redirect:/board/lookup?";
		}
}		