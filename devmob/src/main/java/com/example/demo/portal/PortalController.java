package com.example.demo.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.user.UserDTO;
import com.example.demo.user.UserService;

@Controller
public class PortalController {
	
	@Autowired
    private UserService userService;
	
	@RequestMapping("portal-jsp") 
	public String portal() { 
		return "main/portal/portal"; 
	}
	
	@RequestMapping("portal-popup") 
	public String portal_popup() { 
		return "popup/portal/popup_portal"; 
	}

	@RequestMapping("portal-html") 
	public String welcome(Model model) throws Exception {
	    model.addAttribute("msg", "open html");
	    return "thymeleaf/portal";
	}

	@RequestMapping("login") 
	public String login() { 
		return "thymeleaf/login/index"; 
	}
	
	@RequestMapping("login_fail") 
	public String login_fail() { 
		return "thymeleaf/login/login_fail"; 
	}
	
	@RequestMapping("denied") 
	public String denied() { 
		return "thymeleaf/login/denied"; 
	}
	
	@GetMapping("/signup")
    public String signupView() {
        return "thymeleaf/login/signup";
    }

    @PostMapping("/signup")
    public String signup(UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/login";
    }
    
    @RequestMapping("restTest1")
    public Object restTest1() {
		return "main/portal/test1"; 
    }
}
