package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.pass;


import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.PassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassRepository extends JpaRepository<PassEntity, Long>, PassQueryRepository {
}
