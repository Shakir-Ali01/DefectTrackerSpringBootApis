package com.defecttracker.defecttracker.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.defecttracker.defecttracker.Entity.AddDefectEntity;
import com.defecttracker.defecttracker.Entity.LoginEntity;

public interface AddDefectRepo extends JpaRepository<AddDefectEntity, Integer>{
	List<AddDefectEntity> findByPriorityAndCategory(Integer priority,String category);
//	List<AddDefectEntity> findByPriorityOrCategory(String emailAddress, String lastname);
}
