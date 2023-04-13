package com.bat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bat.entities.SubDealer;
import com.bat.service.SubDealerService;

@Controller
public class SubDealerController {
	@Autowired
	private SubDealerService subDealerService;
	
    @PostMapping("/addSubDealerData")
	public String addingSubDealerData(@ModelAttribute SubDealer subDealer,Model model)
	{
    subDealerService.saveSubDealerData(subDealer);
    System.out.println("Dealer added successfully");
    List<SubDealer> subDealerData=subDealerService.fetchAllData();
	model.addAttribute("subDealerData", subDealerData);
	return "addSubDealer";	
	}
    
    
}
