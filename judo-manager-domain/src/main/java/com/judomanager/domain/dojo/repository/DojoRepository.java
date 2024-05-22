package com.judomanager.domain.dojo.repository;

import com.judomanager.domain.dojo.domain.Dojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DojoRepository extends JpaRepository<Dojo, Long>, DojoQueryRepository {
}
