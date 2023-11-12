package com.iitmsc.developeriq.external.repository;

import com.iitmsc.developeriq.domain.entity.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metrics, Long > {

}
