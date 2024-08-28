package com.audit.persistence.repositories;

import com.audit.persistence.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoryCrudRepository extends JpaRepository<History, Long> {
}
