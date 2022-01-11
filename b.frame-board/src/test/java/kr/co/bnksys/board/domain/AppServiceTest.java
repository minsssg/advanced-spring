package kr.co.bnksys.board.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.bnksys.board.model.User;

@SpringBootTest
class AppServiceTest {

	@Autowired
	AppService appService;
	
	/** 로그인테스트 작성 */
	@Test
	void testLogin() {
		
		assertNotNull(appService);
		// given
		User user = appService.login(
				User.builder()
				.userId("test")
				.password("aa12345^")
				.build()
				);
		
		assertThat(user.getName()).isEqualTo("조영재(JO)");
	}

}
