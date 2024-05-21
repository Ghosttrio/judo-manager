package com.judomanager.domain.repository.dojo;

import com.judomanager.domain.domain.dojo.Dojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DojoRepository extends JpaRepository<Dojo, Long>, DojoQueryRepository {
}
