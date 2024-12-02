package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.DojoRepository;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.projections.DojoCoordinateDto;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoEntity;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;
import com.ghosttrio.judomanager.dojo.application.port.out.DojoJpaPort;
import com.ghosttrio.judomanager.dojo.domain.Dojo;
import com.ghosttrio.judomanager.dojo.mapper.DojoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DojoJpaAdapter implements DojoJpaPort {

    private final DojoRepository dojoRepository;
    private final DojoMapper dojoMapper;

    @Override
    public void save(Dojo dojo) {
        DojoEntity entity = dojoMapper.toEntity(dojo);
        dojoRepository.save(entity);
    }

    @Override
    public Optional<Dojo> findById(Long dojoId) {
        Optional<DojoEntity> dojoEntity = dojoRepository.findById(dojoId);
        return dojoEntity.map(dojoMapper::toDomain);
    }

    @Override
    public List<Dojo> findAll() {
        List<DojoEntity> dojoEntities = dojoRepository.findAll();
        return dojoEntities.stream()
                .map(dojoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Dojo> findByDojoCode(String dojoCode) {
        Optional<DojoEntity> dojoEntity = dojoRepository.findByDojoCode(dojoCode);
        return dojoEntity.map(dojoMapper::toDomain);
    }

    @Override
    public Optional<Dojo> findByUserId(Long userId) {
        Optional<DojoEntity> dojoEntity = dojoRepository.findByUserId(userId);
        return dojoEntity.map(dojoMapper::toDomain);
    }

    @Override
    public DojoCoordinateDto findDojoCoordinate(Long dojoId) {
        return dojoRepository.findDojoCoordinate(dojoId);
    }

    @Override
    public void update(Long dojoId, DojoState state) {
        dojoRepository.update(dojoId, state);
    }
}
