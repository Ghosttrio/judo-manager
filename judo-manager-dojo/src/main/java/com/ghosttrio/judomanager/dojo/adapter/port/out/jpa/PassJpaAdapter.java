package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.PassEntity;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.pass.PassRepository;
import com.ghosttrio.judomanager.dojo.application.port.out.PassJpaPort;
import com.ghosttrio.judomanager.dojo.domain.Pass;
import com.ghosttrio.judomanager.dojo.mapper.PassMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PassJpaAdapter implements PassJpaPort {

    private final PassRepository passRepository;
    private final PassMapper passMapper;

    @Override
    public Optional<Pass> findByUserPass(Long userId) {
        Optional<PassEntity> passEntity = passRepository.findByUserPass(userId);
        return passEntity.map(passMapper::toDomain);
    }
}
