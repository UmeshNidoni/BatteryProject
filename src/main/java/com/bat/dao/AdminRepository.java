package com.bat.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bat.entities.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer>
{
@Query(value="select * from admin where email=:e and password=:p",nativeQuery=true)
public Admin gettingAemailApassword(@Param("e") String email,@Param("p")String password);
}
