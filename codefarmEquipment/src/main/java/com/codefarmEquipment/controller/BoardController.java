package com.codefarmEquipment.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codefarmEquipment.model.Board;
import com.codefarmEquipment.model.User;
import com.codefarmEquipment.repository.BoardRepository;
import com.codefarmEquipment.service.BoardService;
import com.codefarmEquipment.validator.BoardValidator;

@Controller
@RequestMapping("/board")
public class BoardController {
		
		@Autowired
		private BoardRepository boardRepository; //여기에 있는 데이터를 가져오기 
		
	    @Autowired
	    private BoardService boardService;
		
		@Autowired
		private BoardValidator boardValidator;
		
		@GetMapping("/list")
		public String list(Model model, @PageableDefault(size =2) Pageable pageable, 
				@RequestParam(required=false,defaultValue="")String searchText) {
			//Page<Board> boards = boardRepository.findAll(pageable);
			Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);

			int startPage = Math.max(1,boards.getPageable().getPageNumber() -4);
			int endPage = Math.min(boards.getTotalPages(),boards.getPageable().getPageNumber() +4);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("boards",boards); //boards라는 키 값에 boards 라는 데이
			return "board/list";
		}
		
		@GetMapping("/form")
		public String form(Model model, @RequestParam(required =false) Long board_no) {
			if(board_no==null) {
				model.addAttribute("board", new Board());
			}
			else {
				Board board =boardRepository.findById(board_no).orElse(null);
				model.addAttribute("board", board);
			}
			return "board/form";
		}
		
		@PostMapping("/form")
		 public String postForm(@Valid Board board, BindingResult bindingResult, Authentication authentication) { //서버쪽 인증정보 담기 
			boardValidator.validate(board, bindingResult);
			if (bindingResult.hasErrors()) {
				return "board/form";
			}
			
			String username  =authentication.getName();
			 boardService.save(username, board);
			//boardRepository.save(board);
			return "redirect:/board/list";
		}
}