package com.example.demo.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
	private Long id;
    private String title;
    private String content;
    private String userName;
    
    @Builder
    public BoardDTO(Long id, String title, String content, String userName) {
    	this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
    }
    
    public Board toEntity(){
        return Board.builder()
        		.id(id)
        		.title(title)
        		.content(content)
        		.userName(userName)
        		.build();
    }
    
}

