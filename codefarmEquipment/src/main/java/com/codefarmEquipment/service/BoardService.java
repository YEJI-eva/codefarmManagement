package com.codefarmEquipment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codefarmEquipment.model.Board;
import com.codefarmEquipment.model.Role;
import com.codefarmEquipment.model.User;
import com.codefarmEquipment.repository.BoardRepository;
import com.codefarmEquipment.repository.UserRepository;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }


}