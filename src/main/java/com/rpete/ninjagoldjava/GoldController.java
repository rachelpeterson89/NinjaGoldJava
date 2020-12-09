package com.rpete.ninjagoldjava;

import javax.servlet.http.HttpSession;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoldController {
	
	@RequestMapping("/gold")
	public String index(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		System.out.println(gold);
		try {
			if(gold.equals(null)) {
				System.out.println(session.getAttribute("gold"));
			}
		} catch(NullPointerException error) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(
			HttpSession session, 
			Model model,
			@ModelAttribute(value="whichform") String whichform) 
	{
		// get gold from session
		Integer gold = (Integer) session.getAttribute("gold");
		Random r = new Random();
		// logic for adding/deleting gold
		if (whichform.equals("farm")) {
			Integer randInt1 = (Integer) r.nextInt(10) + 10;
			gold += randInt1;
			session.setAttribute("gold", gold);
			System.out.println("Farm: current gold: " + gold);
		} if (whichform.equals("cave")) {
			Integer randInt2 = (Integer) r.nextInt(5) + 5;
			gold += randInt2;
			session.setAttribute("gold", gold);
			System.out.println("Cave: current gold: " + gold);
		} if (whichform.equals("house")) {
			Integer randInt3 = (Integer) r.nextInt(3) + 2;
			gold += randInt3;
			session.setAttribute("gold", gold);
			System.out.println("House: current gold: " + gold);
		} if (whichform.equals("casino")) {
			Integer randInt4 = (Integer) r.nextInt(100) - 50;
			gold += randInt4;
			session.setAttribute("gold", gold);
			System.out.println("Casino: current gold: " + gold);
		}
		model.addAttribute("gold", gold);
		return "redirect:/gold";
		
		
	}
}
