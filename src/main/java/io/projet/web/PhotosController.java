package io.projet.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.projet.domain.Photos;
import io.projet.domain.Project;
import io.projet.services.MapValidationErrorService;
import io.projet.services.PhotosService;
import io.projet.services.ProjectService;

@RestController
@RequestMapping("/api/project/photos")

public class PhotosController {
	
	@Autowired
	 private ProjectService projectservice;
	
	@Autowired
	 private PhotosService photosservice;
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewPhoto(@Valid @RequestBody Photos photo, BindingResult result){
		
	
    	
    	ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    	if(errorMap!=null) return errorMap;
    	
		Photos photo1 = photosservice.saveOrUpdateProject(photo);
		return new ResponseEntity<Photos>(photo, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPhotos(){
		List<Photos> photos= (List) photosservice.findAllPhotos();
		return new ResponseEntity<Photos>((Photos) photos, HttpStatus.OK);
		}
	
	@GetMapping("/photos/{projectId}")
	public ResponseEntity<?> getAlPhotos(@PathVariable String projectId){
		Project project = projectservice.findProjectByIdentifier(projectId);
		List<Photos> photos= (List) photosservice.findPhotosByprojet(project);
		return new ResponseEntity<Photos>((Photos) photos, HttpStatus.OK);
		}
	

}
