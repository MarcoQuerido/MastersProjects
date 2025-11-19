package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.SellStatus;
import org.trebol.repository.SellStatusRepository;
import org.trebol.service.SellStatusService;
import org.trebol.service.dto.SellStatusDTO;
import org.trebol.service.mapper.SellStatusMapper;

/**
 * Service Implementation for managing {@link SellStatus}.
 */
@Service
@Transactional
public class SellStatusServiceImpl implements SellStatusService {

    private final Logger log = LoggerFactory.getLogger(SellStatusServiceImpl.class);

    private final SellStatusRepository sellStatusRepository;

    private final SellStatusMapper sellStatusMapper;

    public SellStatusServiceImpl(SellStatusRepository sellStatusRepository, SellStatusMapper sellStatusMapper) {
        this.sellStatusRepository = sellStatusRepository;
        this.sellStatusMapper = sellStatusMapper;
    }

    @Override
    public SellStatusDTO save(SellStatusDTO sellStatusDTO) {
        log.debug("Request to save SellStatus : {}", sellStatusDTO);
        SellStatus sellStatus = sellStatusMapper.toEntity(sellStatusDTO);
        sellStatus = sellStatusRepository.save(sellStatus);
        return sellStatusMapper.toDto(sellStatus);
    }

    @Override
    public SellStatusDTO update(SellStatusDTO sellStatusDTO) {
        log.debug("Request to update SellStatus : {}", sellStatusDTO);
        SellStatus sellStatus = sellStatusMapper.toEntity(sellStatusDTO);
        sellStatus = sellStatusRepository.save(sellStatus);
        return sellStatusMapper.toDto(sellStatus);
    }

    @Override
    public Optional<SellStatusDTO> partialUpdate(SellStatusDTO sellStatusDTO) {
        log.debug("Request to partially update SellStatus : {}", sellStatusDTO);

        return sellStatusRepository
            .findById(sellStatusDTO.getId())
            .map(existingSellStatus -> {
                sellStatusMapper.partialUpdate(existingSellStatus, sellStatusDTO);

                return existingSellStatus;
            })
            .map(sellStatusRepository::save)
            .map(sellStatusMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SellStatusDTO> findAll() {
        log.debug("Request to get all SellStatuses");
        return sellStatusRepository.findAll().stream().map(sellStatusMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SellStatusDTO> findOne(Long id) {
        log.debug("Request to get SellStatus : {}", id);
        return sellStatusRepository.findById(id).map(sellStatusMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SellStatus : {}", id);
        sellStatusRepository.deleteById(id);
    }
}
