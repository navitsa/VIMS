package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Repair;

public interface RepairRepository  extends CrudRepository<Repair,Integer> {

	@Query(value = "SELECT r FROM Repair r WHERE r.repairDate =:repairDate ")
	public List<Repair> getRepairtDataByDate(@Param("repairDate") String repairDate);
}
