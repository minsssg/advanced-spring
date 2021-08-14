package kr.co.bnksys.board.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static kr.co.bnksys.board.util.CommonUtils.getCurrentTimestamp;

import org.springframework.stereotype.Component;

import kr.co.bnksys.board.domain.UserService;
import kr.co.bnksys.board.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserView {

	private final UserService userService;
	
	public void show() {
		// 화면
		showMenu();
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.print("메뉴를 선택한 후 Enter 키를 눌러주세요.");
				
				String input = bufferedReader.readLine().trim();
				
				if ("q".equals(input)) {
					break;
				}
				
				executeMenu(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("시스템을 종료합니다.");
		System.exit(0);
	}

	private void executeMenu(String input) {
		switch (input) {
		
		case "1":
			insertUser();
			showMenu();
			break;
		}
	}

	private void insertUser() {
		// TODO Auto-generated method stub
		System.out.println("========================================================");
		System.out.println("사용자 등록");
		
		System.out.print("사용자ID: ");
		String userId = getInputString();
		System.out.print("비밀번호: ");
		String password = getInputString();
		System.out.print("이름: ");
		String name = getInputString();
		
		User user = User.builder()
				.userId(userId)
				.password(password)
				.name(name)
				.useYn("Y")
				.fstRgprId(userId)
				.fstRgDtti(getCurrentTimestamp())
				.ltChprId(userId)
				.ltChDtti(getCurrentTimestamp())
				.build();
		
		userService.insertUser(user);
	}

	private String getInputString() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bufferedReader.readLine().trim();
		} catch (IOException e) {
			throw new IllegalArgumentException("데이터를 입력 받지 못했습니다.");
		}
	}

	private void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("========================================================");
		System.out.println("사용자관리 메뉴");
		System.out.println("1. 사용자 등록");
		System.out.println("q. 종료");
		System.out.println("========================================================");
		
	}
}
