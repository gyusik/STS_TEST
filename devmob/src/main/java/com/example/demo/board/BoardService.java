package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {
	//생성자 주입 방식
//	private BoardRepository boardRepository;
//
//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }
	
	//어노테이션 활용
	@Autowired
    BoardRepository boardRepository;
	
	@Autowired
	BoardUtil boardUtil;
    
    @Transactional
    public BoardDTO getBoardDTO(Long Id) {
    	Board board = boardRepository.findById(Id).get();
    	BoardDTO dto = BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .userName(board.getUserName())
                .build();
		return dto;
    }
    
    @Transactional
    public BoardDTO getBoardDTO(Board board) {
    	BoardDTO dto = BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .userName(board.getUserName())
                .build();
		return dto;
    }
    
    @Transactional
    public Board saveBoard(BoardDTO boardDto) {
        return boardRepository.save(boardDto.toEntity());
    }

    @Transactional
    public Page<Board> getBoardList(Pageable pageable) {
        Page<Board> boardList = boardRepository.findAll(pageable);
        boardUtil.diTest();
        return boardList;
    }
    
    @Transactional
    public Page<Board> searchBoard(String searchType, String searchKey,Pageable pageable) {
    	Page<Board> boardList = null;
        switch(searchType) {
        	case "title": boardList = boardRepository.findByTitleContaining(searchKey,pageable);
        	break;
        	case "content": boardList = boardRepository.findByContentContaining(searchKey,pageable);
        	break;
        	case "name": boardList = boardRepository.findByUserNameContaining(searchKey,pageable);
        	break;
        	default:
        	break;
        }
        if(searchType.equals("") && searchKey.equals("")) {
        	boardList = boardRepository.findAll(pageable);
        }
        return boardList;
    }
    
    @Transactional
    public void updateBoard(long Id, String userName, String title, String content) {
    	Board board = boardRepository.findById(Id).get();
    	BoardDTO dto = BoardDTO.builder()
                .id(board.getId())
                .title(title)
                .content(content)
                .userName(userName)
                .build();
    	saveBoard(dto);
    }
    
    @Transactional
    public void deleteBoard(long Id) {
        boardRepository.deleteById(Id);
    }
    
    @Transactional
    public List<BoardDTO> getDTOList(Page<Board> list) {
    	List<BoardDTO> dtoList = new ArrayList<>();
    	if(list.getSize() > 0) {
    		for (Board board : list) {
            	dtoList.add(this.getBoardDTO(board));
            }
    	}
        return dtoList;
    }
}
