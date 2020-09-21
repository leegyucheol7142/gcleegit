package kr.hu.app.controller;


import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
		public String read(BoardBean bb, Model model, @ModelAttribute("sb") SearchBean sb) throws Exception{
			
			model.addAttribute("read", boardService.read(bb.getBoard_no()));
			model.addAttribute("sb", sb
					);
			List<ReplyBean> replyList = replyService.readReply(bb.getBoard_no());
			model.addAttribute("replyList", replyList);
			
			List<Map<String, Object>> fileList = boardService.selectFileList(bb.getBoard_no());
			model.addAttribute("file", fileList);
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
		public String boardwrite(BoardBean bb, MultipartHttpServletRequest mpRequest, HttpSession session) throws Exception {
			UserBean ub = (UserBean) session.getAttribute("loginuser"); String boardId =
			ub.getName(); bb.setUser_no(boardId);
			bb.setContent(bb.getContent().replaceAll("\r\n", "<br>"));
			boardService.setWrite(bb, mpRequest);
			return "redirect:list";
		}
		
		//´ñ±Û ÀÛ¼º
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
		
		//´ñ±Û ¼öÁ¤ 
		@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(ReplyBean rb, SearchBean sb, Model model) throws Exception {
			
			model.addAttribute("replyUpdate", replyService.selectReply(rb.getComment_no()));
			model.addAttribute("sb", sb);
			
			return "board/replyUpdateView";
		}
		
		//´ñ±Û ¼öÁ¤ 
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
		
		//´ñ±Û »èÁ¦ 
		@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(ReplyBean rb, SearchBean sb, Model model) throws Exception {
			
			model.addAttribute("replyDelete", replyService.selectReply(rb.getBoard_no()));
			model.addAttribute("sb", sb);
			System.out.println(rb);
			System.out.println(sb);
			return "board/replyDeleteView";
		}
		
		//´ñ±Û »èÁ¦
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
		
		//Ã·ºÎÆÄÀÏ ´Ù¿î·Îµå
		@RequestMapping(value="/fileDown")
		public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
			Map<String, Object> resultMap = boardService.selectFileInfo(map);
			String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
			String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
			
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\mp\\file\\"+storedFileName));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		}
}		