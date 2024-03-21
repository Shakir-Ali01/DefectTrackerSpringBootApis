package com.defecttracker.defecttracker.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.defecttracker.defecttracker.Entity.LoginEntity;

public interface LoginRepo extends JpaRepository<LoginEntity, Integer>{
	@Query("select l from LoginEntity l where l.name = :name and l.password = :password")
	LoginEntity findByNameAndPassword(@Param("password") String password,
	                             @Param("name") String name);
}
