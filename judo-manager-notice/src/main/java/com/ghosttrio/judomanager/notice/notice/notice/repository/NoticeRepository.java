package com.ghosttrio.judomanager.notice.notice.notice.repository;

import com.ghosttrio.judomanager.notice.notice.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeQueryRepository {
}
