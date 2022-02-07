package com.example.demo.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
//	private BoardService boardService;
//	
//	public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }
	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardUtil boardUtil;
	
	@PostMapping("/saveBoard")
    public void saveBoard(@RequestBody BoardDTO dto){
		dto.setUserName(boardUtil.currentUserName());
		boardService.saveBoard(dto);
    }
	
	@RequestMapping("listBoard")
    public String listBoard(Model model, 
    		@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 10) Pageable pageable){
		Page<Board> list = boardService.getBoardList(pageable);
		List<BoardDTO> dtoList = boardService.getDTOList(list);
		model.addAttribute("page", list.getTotalPages());
		model.addAttribute("list", dtoList);
		return "main/board/listBoard"; 
    }
	
	@RequestMapping("createBoard") 
	public String createBoard() { 
		return "popup/board/createBoard"; 
	}
	
	@RequestMapping("/searchBoard")
    public String searchBoard(@RequestParam(value="searchKey") String searchKey,
    		@RequestParam(value="searchType") String searchType, Model model,
    		@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 10) Pageable pageable){
		Page<Board> list = boardService.searchBoard(searchType,searchKey,pageable);
		List<BoardDTO> dtoList = boardService.getDTOList(list);
		model.addAttribute("page", list.getTotalPages());
		model.addAttribute("list", dtoList);

	    return "main/board/listBoard"; 
    }
	
	@RequestMapping("viewBoard")
    public String viewBoard(@RequestParam(value="id") String id, Model model){
		boolean isCreater = false;
		long londId = Long.parseLong(id);
		BoardDTO dto = boardService.getBoardDTO(londId);
		String currentUserName = boardUtil.currentUserName();
		if(currentUserName.equals(dto.getUserName())) {
			isCreater = true;
		}
		model.addAttribute("isCreater", isCreater);
		model.addAttribute("data", dto);
		return "main/board/viewBoard"; 
    }
	
	@PostMapping("/updateBoard")
    public void updateBoard(@RequestBody Map<String, Object> param){
		String userId = (String) param.get("userId");
		String content = (String) param.get("content");
		String title = (String) param.get("title");
		String userName = (String) param.get("userName");
		long londId = Long.parseLong(userId);
		boardService.updateBoard(londId, userName, title, content);
    }
	
	@PostMapping("/deleteBoard")
    public void deleteBoard(@RequestBody Map<String, Object> param){
		String userId = (String) param.get("userId");
		long londId = Long.parseLong(userId);
		boardService.deleteBoard(londId);
    }

}
