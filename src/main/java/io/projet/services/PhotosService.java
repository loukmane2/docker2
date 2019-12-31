package io.projet.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.projet.domain.Photos;
import io.projet.domain.Project;
import io.projet.exceptions.ProjectIdException;
import io.projet.repositories.PhotosRepository;

@Service
public class PhotosService {
    
	@Autowired
	PhotosRepository photosrepository;
	public List<Photos> findAllPhotos(){
		return photosrepository.findAll();
	}
	public Photos findPhotosByidphotos(Long numero) {
		return photosrepository.findByidphotos(numero);
	}
	
	public List<Photos> findPhotosByprojet(Project projet){
		return photosrepository.findByprojet(projet);
	}
	public Photos saveOrUpdateProject(@Valid Photos photo) {
		try {
			photo.setPath(photo.getPath());
			
			return photosrepository.save(photo);
			
		}catch(Exception e) {
			throw new ProjectIdException("Project ID "+photo.getPath().toUpperCase()+" already exist");
		}
		
	}
	
	
}
