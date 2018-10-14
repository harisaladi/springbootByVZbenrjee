package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp,Integer> {
	
	// userdefined method
	//for this method impl is not required, spring will takecare
	@Query(name="name1", value="select e from Emp e where e.salary between ?1 and ?2")
	public List<Emp> getEmpWithSalBtRange(double s1,double s2);

}
