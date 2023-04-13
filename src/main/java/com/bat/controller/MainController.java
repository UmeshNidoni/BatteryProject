package com.bat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bat.entities.AddSales;
import com.bat.entities.Admin;
import com.bat.entities.SubDealer;
import com.bat.service.AddSalesService;
import com.bat.service.AdminService;
import com.bat.service.SubDealerService;

@Controller
public class MainController 
{
	@Autowired
	private AdminService adminService;
	@Autowired
	private AddSalesService addSalesService;
	@Autowired
	private SubDealerService subDealerService;
	
   @GetMapping("/")
   public String login()
   {
	return "loginpage";
   }
   
   @PostMapping("/validateUser")
   public String validatingUser(@RequestParam("admin_email") String email,@RequestParam("admin_password") String password,Model model)
   {
	
	   Admin adminData=adminService.validateAdmin(email, password);
	   
	  if(adminData!=null)
	  {
		  return "dashboard";
	  }
	  else
	  {
		 model.addAttribute("status",true);
		 return "loginpage"; 
	  }
	   
	   
   }
   
   @GetMapping("/addSales")
   public String addingSales(Model model)
   {
	   List<SubDealer> dealerList=subDealerService.fetchAllData();
	   model.addAttribute("dealerName", dealerList);
	   return "addSales";
   }
   
   @GetMapping("/editSales")
   public String editingSales(Model model)
   {
	   List<AddSales> addSalesData=(List)addSalesService.fetchAllData();
	   model.addAttribute("addSalesData", addSalesData);
	   return "editSales";
   }
   
   @GetMapping("/allSalesReport")
   public String allSalesReport(Model model)
   {
	   List<AddSales> addSalesData=(List)addSalesService.fetchAllData();
	   model.addAttribute("addSalesData", addSalesData);
	   return "allSalesReport";
   }
   
   @GetMapping("/salesReport")
   public String salesReport(Model model)
   {
	   List<SubDealer> dealerList=subDealerService.fetchAllData();
	   model.addAttribute("dealerName", dealerList);
	   return "salesReport";
   }
   
   @GetMapping("/dashBoardPage")
   public String openDashboard()
   {
	   return "dashboard";
   }
   
   @GetMapping("/addSubDealer")
   public String addSubDealer(Model model)
   {
	   List<SubDealer> subDealerData=subDealerService.fetchAllData();
	   model.addAttribute("subDealerData", subDealerData);
	   return "addSubDealer";
   }
}
