package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.Costumer;
import org.trebol.repository.CostumerRepository;
import org.trebol.service.CostumerService;
import org.trebol.service.dto.CostumerDTO;
import org.trebol.service.mapper.CostumerMapper;

/**
 * Service Implementation for managing {@link Costumer}.
 */
@Service
@Transactional
public class CostumerServiceImpl implements CostumerService {

    private final Logger log = LoggerFactory.getLogger(CostumerServiceImpl.class);

    private final CostumerRepository costumerRepository;

    private final CostumerMapper costumerMapper;

    public CostumerServiceImpl(CostumerRepository costumerRepository, CostumerMapper costumerMapper) {
        this.costumerRepository = costumerRepository;
        this.costumerMapper = costumerMapper;
    }

    @Override
    public CostumerDTO save(CostumerDTO costumerDTO) {
        log.debug("Request to save Costumer : {}", costumerDTO);
        Costumer costumer = costumerMapper.toEntity(costumerDTO);
        costumer = costumerRepository.save(costumer);
        return costumerMapper.toDto(costumer);
    }

    @Override
    public CostumerDTO update(CostumerDTO costumerDTO) {
        log.debug("Request to update Costumer : {}", costumerDTO);
        Costumer costumer = costumerMapper.toEntity(costumerDTO);
        costumer = costumerRepository.save(costumer);
        return costumerMapper.toDto(costumer);
    }

    @Override
    public Optional<CostumerDTO> partialUpdate(CostumerDTO costumerDTO) {
        log.debug("Request to partially update Costumer : {}", costumerDTO);

        return costumerRepository
            .findById(costumerDTO.getId())
            .map(existingCostumer -> {
                costumerMapper.partialUpdate(existingCostumer, costumerDTO);

                return existingCostumer;
            })
            .map(costumerRepository::save)
            .map(costumerMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CostumerDTO> findAll() {
        log.debug("Request to get all Costumers");
        return costumerRepository.findAll().stream().map(costumerMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CostumerDTO> findOne(Long id) {
        log.debug("Request to get Costumer : {}", id);
        return costumerRepository.findById(id).map(costumerMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Costumer : {}", id);
        costumerRepository.deleteById(id);
    }
}
