package com.bat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bat.dao.SubDealerRepository;
import com.bat.entities.SubDealer;

@Service
public class SubDealerService {
    @Autowired
    private SubDealerRepository subDealerRepository;
	
	
	public void saveSubDealerData(SubDealer subDealer)
	{
		subDealerRepository.save(subDealer);
	}
	
	public List<SubDealer> fetchAllData()
	{
		List<SubDealer> allData=(List)subDealerRepository.findAll();
		return allData;
	}
}
