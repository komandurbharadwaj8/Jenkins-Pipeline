package com.sts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sts.entities.Sections;

public interface SectionRepository extends JpaRepository<Sections, Integer>{
	
	List<Sections> findBySectionName(String sectionName);

}
