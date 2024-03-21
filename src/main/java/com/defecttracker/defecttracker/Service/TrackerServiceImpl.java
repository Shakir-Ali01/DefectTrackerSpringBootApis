package com.defecttracker.defecttracker.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defecttracker.defecttracker.Entity.AddDefectEntity;
import com.defecttracker.defecttracker.Entity.LoginEntity;
import com.defecttracker.defecttracker.Repo.AddDefectRepo;
import com.defecttracker.defecttracker.Repo.LoginRepo;

@Service
public class TrackerServiceImpl implements TrackerService{
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
	private AddDefectRepo addDefectRepo;
	public LoginEntity Userlogin(String username,String password) 
	{
	   LoginEntity loginUserInfo=loginRepo.findByNameAndPassword(password, username);
		return loginUserInfo;
		
	}
	@Override
	public AddDefectEntity saveDefect(AddDefectEntity addDefect) {
		// TODO Auto-generated method stub
		return addDefectRepo.saveAndFlush(addDefect);
	}
	@Override
	public String updateStatus(Integer id) {
		// TODO Auto-generated method stub
		Optional<AddDefectEntity> optional=addDefectRepo.findById(id);
		if(optional.isPresent())
		{
				AddDefectEntity aEntity=optional.get();
				aEntity.setStatus("closed");
				addDefectRepo.save(aEntity);
				return "Status updated successfully";
			
		}
		return "This Defect Info is not Present";
	}
	@Override
	public List<AddDefectEntity> findAll() {
		// TODO Auto-generated method stub
		Iterable<AddDefectEntity> defects = addDefectRepo.findAll();
		List<AddDefectEntity> defectEntity = new ArrayList<>();
		defects.forEach(defect -> {
			AddDefectEntity defectentity = new AddDefectEntity();
			defectentity.setId(defect.getId());
			defectentity.setCategory(defect.getCategory());
			defectentity.setDescription(defect.getDescription());
			defectentity.setPriority(defect.getPriority());
			defectentity.setStatus(defect.getStatus());
			defectEntity.add(defectentity);
		});
		return defectEntity;
	}
	@Override
	public List<AddDefectEntity> getAllDefectWithFilter(Integer priority,String category) {
		// TODO Auto-generated method stu
		Iterable<AddDefectEntity> defects =(Iterable<AddDefectEntity>) addDefectRepo.findByPriorityAndCategory(priority,category);
		List<AddDefectEntity> defectEntity = new ArrayList<>();
		defects.forEach(defect -> {
			AddDefectEntity defectentity = new AddDefectEntity();
			defectentity.setId(defect.getId());
			defectentity.setCategory(defect.getCategory());
			defectentity.setDescription(defect.getDescription());
			defectentity.setPriority(defect.getPriority());
			defectentity.setStatus(defect.getStatus());
			defectEntity.add(defectentity);
		});
		return defectEntity;
		
	}
	
}
