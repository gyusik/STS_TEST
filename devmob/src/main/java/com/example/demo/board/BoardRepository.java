package com.example.demo.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository 어노테이션 사용 불필요
public interface BoardRepository extends JpaRepository<Board, Long>{
	//https://docs.spring.io/spring-data/jpa/docs/1.10.1.RELEASE/reference/html/#jpa.sample-app.finders.strategies
	//메소드 이름에 따라 검색조건이 변한다. 규칙은 위 사이트에 정리되어있다.
	Page<Board> findByTitleContaining(String keyword,Pageable pageable);
	Page<Board> findByContentContaining(String keyword,Pageable pageable);
	Page<Board> findByUserNameContaining(String keyword,Pageable pageable);
}
