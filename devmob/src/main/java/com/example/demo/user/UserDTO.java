package com.example.demo.user;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
	private Long id;
    private String name;
    private String account;
    private String password;
    private LocalDateTime lastAccessDt;
    private LocalDateTime regDt;

    @Builder
    public UserDTO(Long id, String name, String account, String password) {
    	this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
    }
    
    public Users toEntity(){
        return Users.builder()
        		.id(id)
        		.name(name)
        		.account(account)
        		.password(password)
        		.build();
    }
}
