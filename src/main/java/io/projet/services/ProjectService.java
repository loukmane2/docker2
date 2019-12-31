package io.projet.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.projet.domain.Project;
import io.projet.exceptions.ProjectIdException;
import io.projet.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);	
		}catch(Exception e) {
			throw new ProjectIdException("Project ID "+project.getProjectIdentifier().toUpperCase()+" already exist");
		}
		
	}
	
	
	
	
public Iterable<Project> findAllProject() {
		
		
		
		return projectRepository.findAll();
		
	}
	
	public Project findProjectByIdentifier(String projectId) {
		
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Project ID  does not exist");
		}
		
		return  project;
		
	}
	
	
	public Map<String, Object>  deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		Map<String, Object> map=new HashMap<String, Object>();
		if(project != null) {
			projectRepository.delete(project);
			map.put("success", true);
			map.put("message", "le project Inexistqnt");
		}else {
			map.put("success", false);
			map.put("message", "le project Inexistqnt");
		}
		
		return map;
	}
	
	

}
