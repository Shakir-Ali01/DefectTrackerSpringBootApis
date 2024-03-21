package com.defecttracker.defecttracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.defecttracker.defecttracker.Entity.AddDefectEntity;
import com.defecttracker.defecttracker.Entity.LoginEntity;
import com.defecttracker.defecttracker.Service.TrackerService;
@RestController
@CrossOrigin
@RequestMapping("/DefectTracker")
public class TrackerController {
	
	@Autowired
	private TrackerService trackerService;
	@PostMapping
	   public ResponseEntity<AddDefectEntity> createDefect(@RequestBody AddDefectEntity addDefect)
	   {
		   AddDefectEntity addedDefect=trackerService.saveDefect(addDefect);
		   return ResponseEntity.status(HttpStatus.CREATED).body(addDefect);
	   }
	@GetMapping("/{username}/{password}")
	   public  ResponseEntity<LoginEntity> getSingleUser(@PathVariable String username,@PathVariable String password)
	   {
		  LoginEntity userCredential= trackerService.Userlogin(username,password);
		  return ResponseEntity.ok(userCredential);
	   }
	@PutMapping("/{id}")
	public String updateStatus(@PathVariable Integer id)
	{
		return trackerService.updateStatus(id);
	}
	   @GetMapping("/getAllDefect")
	   public  ResponseEntity<List<AddDefectEntity>> getAllDefect()
	   {
		List<AddDefectEntity>  getAllDefect= trackerService.findAll();
		  return ResponseEntity.ok(getAllDefect);
	   }
       
	   @GetMapping("/getAllDefect/{priority}/{category}")
	   public  ResponseEntity<List<AddDefectEntity>> getAllDefectWithFilter(@PathVariable Integer priority,
			   @PathVariable String category)
	   {
		List<AddDefectEntity>  getAllDefect= trackerService.getAllDefectWithFilter(priority,category);
		  return ResponseEntity.ok(getAllDefect);
	   }
	
}
