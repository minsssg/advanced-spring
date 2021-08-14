package kr.co.bnksys.board.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.co.bnksys.board.model.User;
import kr.co.bnksys.board.util.CommonUtils;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	@DisplayName("유저 등록 테스트")
	void testInsertUser() {
		assertNotNull(userService); // Not Null 인지 검증
		
		User user = User.builder()
				.userId("2111103")
				.password("aa12345^")
				.name("김민석")
				.useYn("Y")
				.fstRgprId("2111103")
				.fstRgDtti(CommonUtils.getCurrentTimestamp())
				.ltChprId("2111103")
				.ltChDtti(CommonUtils.getCurrentTimestamp())
				.build();
		
		userService.insertUser(user);
	}
	
	@Test
	void testFindAllUser() {
		Page<User> page = userService.findAllUser(User.builder().build(), PageRequest.of(0, 10));
		assertThat(page.getContent().size()).isGreaterThan(0);
	}

}
