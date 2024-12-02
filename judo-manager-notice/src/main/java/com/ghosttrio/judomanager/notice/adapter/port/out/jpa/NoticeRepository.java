package com.ghosttrio.judomanager.notice.adapter.port.out.jpa;


import com.ghosttrio.judomanager.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeQueryRepository, NoticeCommandRepository {
}
