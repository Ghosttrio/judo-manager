package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo;


import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DojoRepository extends JpaRepository<DojoEntity, Long>, DojoQueryRepository, DojoCommandRepository {
}
