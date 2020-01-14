package io.projet.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.projet.domain.ProjectTask;
import java.util.List;


@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

    List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

    ProjectTask findByProjectSequence(String sequence);
}
