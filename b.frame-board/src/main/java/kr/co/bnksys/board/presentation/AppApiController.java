package kr.co.bnksys.board.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.bnksys.board.domain.AppService;
import kr.co.bnksys.board.model.User;
import kr.co.bnksys.board.model.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api")
@RestController
public class AppApiController {
	
	private final AppService appService;
	
	@PostMapping("login")
	public Map<String, Object> login(@RequestBody User params, HttpSession session) {
		
		log.debug("params: {}", params.getPassword());
		log.debug("session id: {}", session.getId());
		
		User user = appService.login(params);
		
		if (user == null) {
			throw new RuntimeException("사용자 정보가 존재하지 않습니다.");
		}
		
		UserVO userVO = new UserVO(user);
		session.setAttribute(UserVO.class.getSimpleName(), userVO);
		
		Map<String, Object> response = new HashMap<>();
		response.put("success", true);
		response.put("user", user);
		return response;
	}
}
