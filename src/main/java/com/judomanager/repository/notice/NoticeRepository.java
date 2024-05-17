package com.judomanager.repository.notice;

import com.judomanager.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeQueryRepository {
}
