package com.codefarmEquipment.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codefarmEquipment.model.Board;

@Component
public class BoardValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		 return Board.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Board board =(Board) obj;
		if(StringUtils.isEmpty(board.getContent())) {
			errors.rejectValue("content", "key","내용을 입력하세요");
		}
	}

}
