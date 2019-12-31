package io.projet.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.projet.domain.Photos;
import io.projet.domain.Project;





public interface PhotosRepository extends CrudRepository<Photos,Long> {

	 @Override
	    List<Photos> findAll();
	    Photos findByidphotos(Long numero);
	    List<Photos> findByprojet(Project projet);
}
