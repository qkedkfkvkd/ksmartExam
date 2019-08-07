package kr.or.ksmart.ksmart_TestPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_TestPro.service.BoardService;
import kr.or.ksmart.ksmart_TestPro.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "/board/bInsert/addBoard";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(Board board) {
		System.out.println(board + " <- board   addBoard()   BoardController.java");
		int result = boardService.addBoard(board);
		System.out.println(result + " <- result   addBoard()   BoardController.java");
		return "redirect:/boardList";
	}
	
	@GetMapping("/boardList")
	public String boardList(
			 Model model
			,@RequestParam(value = "currentPage"
						  ,required = false		// 반드시 받아야할 필요가 없다. 안 받을시 에러나는걸 방지한다.
						  ,defaultValue = "1") int currentPage) {
		
		model.addAttribute("boardList", boardService.boardList(currentPage));
		return "/board/bList/boardList";
	}
	
	@PostMapping("/boardList")
	public String boardList(
			 @RequestParam(value = "sk") String sk
			,@RequestParam(value = "sv") String sv
			,Model model) {
		model.addAttribute("boardList",
				boardService.boardList(sk, sv));
		return "/board/bList/boardList";
	}
}
