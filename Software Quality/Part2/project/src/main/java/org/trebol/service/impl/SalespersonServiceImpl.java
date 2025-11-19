package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.Salesperson;
import org.trebol.repository.SalespersonRepository;
import org.trebol.service.SalespersonService;
import org.trebol.service.dto.SalespersonDTO;
import org.trebol.service.mapper.SalespersonMapper;

/**
 * Service Implementation for managing {@link Salesperson}.
 */
@Service
@Transactional
public class SalespersonServiceImpl implements SalespersonService {

    private final Logger log = LoggerFactory.getLogger(SalespersonServiceImpl.class);

    private final SalespersonRepository salespersonRepository;

    private final SalespersonMapper salespersonMapper;

    public SalespersonServiceImpl(SalespersonRepository salespersonRepository, SalespersonMapper salespersonMapper) {
        this.salespersonRepository = salespersonRepository;
        this.salespersonMapper = salespersonMapper;
    }

    @Override
    public SalespersonDTO save(SalespersonDTO salespersonDTO) {
        log.debug("Request to save Salesperson : {}", salespersonDTO);
        Salesperson salesperson = salespersonMapper.toEntity(salespersonDTO);
        salesperson = salespersonRepository.save(salesperson);
        return salespersonMapper.toDto(salesperson);
    }

    @Override
    public SalespersonDTO update(SalespersonDTO salespersonDTO) {
        log.debug("Request to update Salesperson : {}", salespersonDTO);
        Salesperson salesperson = salespersonMapper.toEntity(salespersonDTO);
        salesperson = salespersonRepository.save(salesperson);
        return salespersonMapper.toDto(salesperson);
    }

    @Override
    public Optional<SalespersonDTO> partialUpdate(SalespersonDTO salespersonDTO) {
        log.debug("Request to partially update Salesperson : {}", salespersonDTO);

        return salespersonRepository
            .findById(salespersonDTO.getId())
            .map(existingSalesperson -> {
                salespersonMapper.partialUpdate(existingSalesperson, salespersonDTO);

                return existingSalesperson;
            })
            .map(salespersonRepository::save)
            .map(salespersonMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalespersonDTO> findAll() {
        log.debug("Request to get all Salespeople");
        return salespersonRepository.findAll().stream().map(salespersonMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SalespersonDTO> findOne(Long id) {
        log.debug("Request to get Salesperson : {}", id);
        return salespersonRepository.findById(id).map(salespersonMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Salesperson : {}", id);
        salespersonRepository.deleteById(id);
    }
}
