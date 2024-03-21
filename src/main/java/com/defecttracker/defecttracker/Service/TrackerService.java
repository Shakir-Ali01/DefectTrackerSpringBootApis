package com.defecttracker.defecttracker.Service;

import java.util.List;

import com.defecttracker.defecttracker.Entity.AddDefectEntity;
import com.defecttracker.defecttracker.Entity.LoginEntity;

public interface TrackerService {
	public LoginEntity Userlogin(String username,String password); 
	public AddDefectEntity saveDefect(AddDefectEntity addDefect);
	public String updateStatus(Integer id);
	public List<AddDefectEntity> findAll();
	public List<AddDefectEntity> getAllDefectWithFilter(Integer priority,String category);
}
