package io.projet.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.projet.domain.Project;
import io.projet.services.MapValidationErrorService;
import io.projet.services.ProjectService;

@RestController

@CrossOrigin(origins = "*" , maxAge=3600)
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	 private ProjectService projectservice;
	
    @Autowired
    private MapValidationErrorService mapValidationErrorService;
	
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("")
	public ResponseEntity<?> createNewProjet(@Valid @RequestBody Project project, BindingResult result){
		
	
    	
    	ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    	if(errorMap!=null) return errorMap;
    	
		Project project1 = projectservice.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId){
		
    	Project project = projectservice.findProjectByIdentifier(projectId);
		
    	
    	return new ResponseEntity<Project>(project, HttpStatus.OK);
		
	}
    
   // @CrossOrigin(origins = "http://localhost:3000")
   // @GetMapping("/delete/{projectId}")
    @RequestMapping(value = "/delete/{projectId}", produces = {"application/json; charset=UTF-8"}, method = RequestMethod.GET)
    @ResponseBody
    		public Map<String, Object>  deleteProject(@PathVariable String projectId){
    	
				
    	return  projectservice.deleteProjectByIdentifier(projectId); 
    		}
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public Iterable<Project> getAllProject(){
        
        return  projectservice.findAllProject();
    }
    
}
   