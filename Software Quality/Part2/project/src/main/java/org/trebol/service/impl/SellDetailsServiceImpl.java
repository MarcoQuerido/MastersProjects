package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.SellDetails;
import org.trebol.repository.SellDetailsRepository;
import org.trebol.service.SellDetailsService;
import org.trebol.service.dto.SellDetailsDTO;
import org.trebol.service.mapper.SellDetailsMapper;

/**
 * Service Implementation for managing {@link SellDetails}.
 */
@Service
@Transactional
public class SellDetailsServiceImpl implements SellDetailsService {

    private final Logger log = LoggerFactory.getLogger(SellDetailsServiceImpl.class);

    private final SellDetailsRepository sellDetailsRepository;

    private final SellDetailsMapper sellDetailsMapper;

    public SellDetailsServiceImpl(SellDetailsRepository sellDetailsRepository, SellDetailsMapper sellDetailsMapper) {
        this.sellDetailsRepository = sellDetailsRepository;
        this.sellDetailsMapper = sellDetailsMapper;
    }

    @Override
    public SellDetailsDTO save(SellDetailsDTO sellDetailsDTO) {
        log.debug("Request to save SellDetails : {}", sellDetailsDTO);
        SellDetails sellDetails = sellDetailsMapper.toEntity(sellDetailsDTO);
        sellDetails = sellDetailsRepository.save(sellDetails);
        return sellDetailsMapper.toDto(sellDetails);
    }

    @Override
    public SellDetailsDTO update(SellDetailsDTO sellDetailsDTO) {
        log.debug("Request to update SellDetails : {}", sellDetailsDTO);
        SellDetails sellDetails = sellDetailsMapper.toEntity(sellDetailsDTO);
        sellDetails = sellDetailsRepository.save(sellDetails);
        return sellDetailsMapper.toDto(sellDetails);
    }

    @Override
    public Optional<SellDetailsDTO> partialUpdate(SellDetailsDTO sellDetailsDTO) {
        log.debug("Request to partially update SellDetails : {}", sellDetailsDTO);

        return sellDetailsRepository
            .findById(sellDetailsDTO.getId())
            .map(existingSellDetails -> {
                sellDetailsMapper.partialUpdate(existingSellDetails, sellDetailsDTO);

                return existingSellDetails;
            })
            .map(sellDetailsRepository::save)
            .map(sellDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SellDetailsDTO> findAll() {
        log.debug("Request to get all SellDetails");
        return sellDetailsRepository.findAll().stream().map(sellDetailsMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SellDetailsDTO> findOne(Long id) {
        log.debug("Request to get SellDetails : {}", id);
        return sellDetailsRepository.findById(id).map(sellDetailsMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SellDetails : {}", id);
        sellDetailsRepository.deleteById(id);
    }
}
