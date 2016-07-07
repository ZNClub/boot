package com.znevzz.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {
	
	@RequestMapping("/status")
	public String status(Model model){
		
		model.addAttribute("h", "HELLO BOOT");
		
		return "index";
		
	}
	
	@RequestMapping(
			value="/load",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	//public ResponseEntity<Collection<String>> load(Model model){			
	public ResponseEntity<String[]> load(Model model){
		Map<String, String> m= new HashMap<String, String>();
		m.put("1","ZNevzz");
		m.put("2","JSON");
		String[] names = new String[]{"A","B"};
		//return new ResponseEntity<Collection<String>>(m.values(),HttpStatus.OK);
		return new ResponseEntity<String[]>(names,HttpStatus.OK);
	}

	@RequestMapping(
			value="/not-found",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)				
	public ResponseEntity<String[]> notFound(Model model){
					
		return new ResponseEntity<String[]>(HttpStatus.NOT_FOUND);
	}
}
