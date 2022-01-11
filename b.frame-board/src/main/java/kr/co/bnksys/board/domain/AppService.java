package kr.co.bnksys.board.domain;

import kr.co.bnksys.board.model.User;

public interface AppService {
	
	/** 로그인 */
	User login(User user);
}
