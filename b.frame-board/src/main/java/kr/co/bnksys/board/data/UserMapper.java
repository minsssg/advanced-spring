package kr.co.bnksys.board.data;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import kr.co.bnksys.board.model.User;

public interface UserMapper {

	void insertUser(User user);

	long findAllUserCount(User user);
	
	// 객체가 두 개가 넘어오면 하나를 선택할 수 있게 해야 한다.
	List<User> findAllUser(@Param("user") User user, @Param("pageable") Pageable pageable);

}
