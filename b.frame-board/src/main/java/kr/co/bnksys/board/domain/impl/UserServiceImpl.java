package kr.co.bnksys.board.domain.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.bnksys.board.data.UserMapper;
import kr.co.bnksys.board.domain.UserService;
import kr.co.bnksys.board.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	@Override
	public Page<User> findAllUser(User user, Pageable pageable) {
		
		
		long total = userMapper.findAllUserCount(user);

		if (total == 0) {
			return new PageImpl<>(new ArrayList<User>(), pageable, total);
		}
		
		List<User> content = userMapper.findAllUser(user, pageable);;
		
		return new PageImpl<>(content, pageable, total); // 페이징 처리가 된 리스트를 볼 수 있다.
	}
	
	@Transactional
	@Override
	public void insertUser(User user) {
		// 사용하는 측면에서 사용하는 매서드를 먼저 만들고 Mapper에 메서드를 생성한다.
		// 사용자 친화적인 개발 방식.
		userMapper.insertUser(user);
	}
}
