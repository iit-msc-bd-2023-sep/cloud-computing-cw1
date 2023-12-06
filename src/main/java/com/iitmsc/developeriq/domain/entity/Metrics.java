package com.iitmsc.developeriq.domain.entity;

import com.iitmsc.developeriq.util.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Where( clause = "is_deleted = 0" )
@Table(
        name = "metrics", // Replace with your actual table name
        uniqueConstraints = {
                @UniqueConstraint(name = Constants.DUPLICATE_METRIC_NAME,columnNames = {"owner", "repo"})
        }
)

public class Metrics extends AbstractEntity{

    private String owner;

    private String repo;

    private Integer totalIssues;

    private Integer totalCommits;

    private Integer totalPullRequests;

    private Integer totalForks;
}
