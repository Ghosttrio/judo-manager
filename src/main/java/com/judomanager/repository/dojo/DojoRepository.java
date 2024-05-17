package com.judomanager.repository.dojo;

import com.judomanager.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DojoRepository extends JpaRepository<Notice, Long>, DojoQueryRepository {
}
