package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // controller - req resp - session - singleton 
public class CalcController {

	
	@GetMapping("inputcalc")
	public String inputCalc() {
		return "InputCalc";
	}
	
	@PostMapping("calc")
	public String calc(Integer n1,Integer n2,Model model) {
		Integer ans = n1 + n2;
		System.out.println(ans);
		model.addAttribute("ans",ans);//send ans to Answer.jsp 
		return "Answer";
	}
}
