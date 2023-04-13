package com.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bat.dao.AdminRepository;
import com.bat.entities.Admin;

@Service
public class AdminService {
@Autowired
private AdminRepository adminRepository;


public Admin validateAdmin(String email,String password)
{
	Admin ad = adminRepository.gettingAemailApassword(email, password);
	return ad;
}
}
