package com.bat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bat.dao.AddSalesRepository;
import com.bat.entities.AddSales;

@Service
public class AddSalesService {
    @Autowired
	private AddSalesRepository addSalesRepository;
    
	public void saveAddSales(AddSales addSales)
	{
		addSalesRepository.save(addSales);
	}
	
	public List<AddSales> fetchAllData()
	{
		List<AddSales> allSalesData=(List)addSalesRepository.findAll();
		return allSalesData;
	}
	
	public AddSales findDataByIdForEditingSalesdata(int id)
	{
		Optional<AddSales> dataById=addSalesRepository.findById(id);
		AddSales as=null;
		if(dataById.isPresent())
		{
			as=dataById.get();
		}
		else {
			throw new RuntimeException("Sales data Not Found of id"+" "+id);
		}
		return as;
	}
	
	public List<AddSales> getDataBySubDealerName(String name)
	{
		List<AddSales> dataByName=addSalesRepository.fetchingDataBySubDealerName(name);
		return dataByName;
	}
	
	public int getDataBySubDealerNameForPreBal(String name)
	{
		int preBal= addSalesRepository.fetchngDataBySubDealerNameForPreBalance(name);
		return preBal;
	}
	public void deletetingDataById(int id)
	{
		addSalesRepository.deleteById(id);
	}
}
