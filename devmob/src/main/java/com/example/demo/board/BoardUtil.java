package com.example.demo.board;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

//클래스 빈 등록 - BoardService에 의존성 주입하여 사용
@Component
public class BoardUtil {
	
	public void diTest() {
		System.out.println("DI TEST !");
	}
	
	public String currentUserName() { 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		User user = (User) authentication.getPrincipal(); 
		return user.getUsername(); 
	}

}
