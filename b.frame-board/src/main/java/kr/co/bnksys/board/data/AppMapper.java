package kr.co.bnksys.board.data;

import kr.co.bnksys.board.model.User;

public interface AppMapper {

	/** 로그인 */
	User login(User user);
}
