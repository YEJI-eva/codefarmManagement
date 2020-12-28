package com.codefarmEquipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.codefarmEquipment.model.Board;
import com.codefarmEquipment.repository.BoardRepository;

@RestController
@RequestMapping("/api")
class BoardApiController{

  @Autowired
  private BoardRepository repository;

  @GetMapping("/boards")
  List<Board> all(@RequestParam(required =false,defaultValue ="") String title,
		  @RequestParam(required =false, defaultValue="") String content){
	  if(StringUtils.isEmpty(title)&& StringUtils.isEmpty(content)) {
		  return repository.findAll();
	  }else {
		  return repository.findByTitleOrContent(title, content);
	  }
  }

  @PostMapping("/boards")
  Board newBoard(@RequestBody Board newBoard) {
    return repository.save(newBoard);
  }

  // Single item

  @GetMapping("/boards/{board_no}")
  Board one(@PathVariable Long board_no) {
    return repository.findById(board_no).orElse(null);
  }

  @PutMapping("/boards/{board_no}")
  Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long board_no) {

    return repository.findById(board_no)
      .map(board -> {
        board.setTitle(newBoard.getTitle());
        board.setContent(newBoard.getContent());
        return repository.save(board);
      })
      .orElseGet(() -> {
        newBoard.setBoard_no(board_no);
        return repository.save(newBoard);
      });
  }

  @DeleteMapping("/Boards/{id}")
  void deleteBoard(@PathVariable Long board_no) {
    repository.deleteById(board_no);
  }
}