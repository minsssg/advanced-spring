package kr.co.bnksys.board.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.co.bnksys.board.model.User;

public interface UserService {

	Page<User> findAllUser(User user, Pageable pageable);
	
	void insertUser(User user);
	
}
