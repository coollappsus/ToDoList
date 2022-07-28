package main.repository;

import main.model.Neuter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeuterRepository extends JpaRepository<Neuter, Integer> {
}
