package com.bat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bat.entities.AddSales;

@Repository
public interface AddSalesRepository extends CrudRepository<AddSales,Integer>
{
	@Query(value="select * from add_sales where sub_dealer=:n",nativeQuery=true)
     public List<AddSales> fetchingDataBySubDealerName(@Param("n") String name);
	
	@Query(value="select sum(balance_payment) from add_sales where sub_dealer=:n",nativeQuery=true)
	public int fetchngDataBySubDealerNameForPreBalance(@Param("n") String name);
}
