package com.bat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bat.entities.SubDealer;
@Repository
public interface SubDealerRepository extends CrudRepository<SubDealer,Integer> {

}
