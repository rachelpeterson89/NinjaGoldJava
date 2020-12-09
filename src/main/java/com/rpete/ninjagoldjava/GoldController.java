package com.rpete.ninjagoldjava;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
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
			ArrayList<String> log = new ArrayList<String>();
			session.setAttribute("log", log);
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
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
		Random r = new Random();
		// logic for adding/deleting gold
		if (whichform.equals("farm")) {
			Integer randInt1 = (Integer) r.nextInt(10) + 10;
			gold += randInt1;
			session.setAttribute("gold", gold);
			log.add("You went to the farm and found " + randInt1 + " gold.");
			System.out.println("Farm: current gold: " + gold);
		} if (whichform.equals("cave")) {
			Integer randInt2 = (Integer) r.nextInt(5) + 5;
			gold += randInt2;
			session.setAttribute("gold", gold);
			log.add("You crawled into a cave and found " + randInt2 + " gold.");
			System.out.println("Cave: current gold: " + gold);
		} if (whichform.equals("house")) {
			Integer randInt3 = (Integer) r.nextInt(3) + 2;
			gold += randInt3;
			session.setAttribute("gold", gold);
			log.add("You went back home and found " + randInt3 + " gold.");
			System.out.println("House: current gold: " + gold);
		} if (whichform.equals("casino")) {
			Integer randInt4 = (Integer) r.nextInt(100) - 50;
			gold += randInt4;
			session.setAttribute("gold", gold);
			log.add("You tested your luck at the casino and found " + randInt4 + " gold.");
			System.out.println("Casino: current gold: " + gold);
		}
		session.setAttribute("log", log);
		model.addAttribute("gold", gold);
		return "redirect:/gold";
		
		
	}
}
