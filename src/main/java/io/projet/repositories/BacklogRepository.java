package io.projet.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.projet.domain.Backlog;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String Identifier);
}