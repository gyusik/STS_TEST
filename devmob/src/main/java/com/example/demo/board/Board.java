package com.example.demo.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//파라미터가 없는 기본 생성자를 생성 
@NoArgsConstructor(access = AccessLevel.PROTECTED) // @Builder를 통해서 접근가능. 기본생성자에 접근할 수 없다.
@Getter
@Entity // JPA Entity로 관리. 서버 시작 시 하이버네이트 -> 테이블 생성
@Table(name = "noticeBoard") // 테이블의 이름 지정. 기본값은 class 이름
public class Board {
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String userName;

    @Builder
    public Board(Long id, String title, String content, String userName) {
    	this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
    }
    
}
