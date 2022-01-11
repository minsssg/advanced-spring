package kr.co.bnksys.board.domain.impl;

import org.springframework.stereotype.Service;

import kr.co.bnksys.board.data.AppMapper;
import kr.co.bnksys.board.domain.AppService;
import kr.co.bnksys.board.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AppServiceImpl implements AppService {

	private final AppMapper appMapper;
	
	/** 로그인 */
	@Override
	public User login(User user) {
		return appMapper.login(user);
	}

}
