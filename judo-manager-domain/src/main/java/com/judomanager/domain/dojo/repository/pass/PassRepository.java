package com.judomanager.domain.dojo.repository.pass;

import com.judomanager.domain.dojo.domain.Pass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassRepository extends JpaRepository<Pass, Long>, PassQueryRepository {
}
