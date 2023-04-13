package com.bat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bat.entities.AddSales;
import com.bat.entities.SubDealer;
import com.bat.service.AddSalesService;
import com.bat.service.SubDealerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.ConsoleAppender;



@Controller
public class AddSalesController {
	@Autowired
    private AddSalesService addSalesService;
	@Autowired
	private SubDealerService subDealerService;
	
	@PostMapping("/addSalesData")
	public String addSalesData(@ModelAttribute AddSales addSales,Model model)
	{
		addSalesService.saveAddSales(addSales);
		System.out.println("data saved successfully");
		 List<SubDealer> dealerList=subDealerService.fetchAllData();
		 model.addAttribute("dealerName", dealerList);
		return "addSales";
	}
	
	//taking id from editSales page when clicked on edit link
	@GetMapping("/showingDataInFormForUpdating/{dealerId}")
	public String editingAddSalesData(@PathVariable("dealerId") int id,Model model)
	{
		
		AddSales salesData=addSalesService.findDataByIdForEditingSalesdata(id);
		model.addAttribute("editSalesData", salesData);
		return "editSalesUpdate";
	}
	
	//taking data from editSalesUpdate page to update data
	@PostMapping("/showingDataInFormForUpdating/editedSalesData")
	public String updatingSalesData(@ModelAttribute AddSales addSales)
	{
		addSalesService.saveAddSales(addSales);
		System.out.println("data updated successfully");
		return "redirect:/editSales";
	}
	
	@PostMapping("/getDataByDealerName")
	public String showintDataByDealerName(@RequestParam("sub_dealer") String dealerName,Model model)
	{
		System.out.println("Hi");
		  Logger logger = LoggerFactory.getLogger(SimpleMDC.class);
		  logger.error("Check enclosed.");
		System.out.println(dealerName);
		List<AddSales> dealerData = addSalesService.getDataBySubDealerName(dealerName);
		model.addAttribute("dealerData", dealerData);
		List<SubDealer> dealerList=subDealerService.fetchAllData();
		   model.addAttribute("dealerName", dealerList);
		return "salesReport";
	}
	@PostMapping("/fetchDataByAjaxCall")
	@ResponseBody
	public int dropDownNameForPreBal(@RequestParam("sub_dealer_name") String name)
	{
		int prevBalance;
		System.out.println(name);
		List<AddSales> dealerData = addSalesService.getDataBySubDealerName(name);
		if(dealerData.isEmpty())
		{
			prevBalance=0;
			return prevBalance;
		}else {
			 prevBalance= addSalesService.getDataBySubDealerNameForPreBal(name);
		}
		
		return prevBalance;
	}
	
	@GetMapping("/deleteDataById/{dealerId}")
	public String deleteDataById(@PathVariable("dealerId") int id)
	{
		System.out.println(id);
		addSalesService.deletetingDataById(id);
		return "redirect:/editSales";
	}
}
