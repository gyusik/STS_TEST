package com.example.demo.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInterface extends UserDetailsService{
	Long save(UserDTO userDTO);
}
