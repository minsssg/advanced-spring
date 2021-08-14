package kr.co.bnksys.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import kr.co.bnksys.board.presentation.UserView;

//@SpringBootApplication
public class UserApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserView view = applicationContext.getBean(UserView.class);
		view.show();
	}

	
}
