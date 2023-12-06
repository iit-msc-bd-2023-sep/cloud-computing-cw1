package com.iitmsc.developeriq.external.repository;

import com.iitmsc.developeriq.domain.entity.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetricRepository extends JpaRepository<Metrics, Long > {

    Optional<Metrics> findByOwnerAndRepo(String owner, String repo);
}
