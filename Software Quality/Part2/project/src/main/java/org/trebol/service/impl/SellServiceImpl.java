package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.Sell;
import org.trebol.repository.SellRepository;
import org.trebol.service.SellService;
import org.trebol.service.dto.SellDTO;
import org.trebol.service.mapper.SellMapper;

/**
 * Service Implementation for managing {@link Sell}.
 */
@Service
@Transactional
public class SellServiceImpl implements SellService {

    private final Logger log = LoggerFactory.getLogger(SellServiceImpl.class);

    private final SellRepository sellRepository;

    private final SellMapper sellMapper;

    public SellServiceImpl(SellRepository sellRepository, SellMapper sellMapper) {
        this.sellRepository = sellRepository;
        this.sellMapper = sellMapper;
    }

    @Override
    public SellDTO save(SellDTO sellDTO) {
        log.debug("Request to save Sell : {}", sellDTO);
        Sell sell = sellMapper.toEntity(sellDTO);
        sell = sellRepository.save(sell);
        return sellMapper.toDto(sell);
    }

    @Override
    public SellDTO update(SellDTO sellDTO) {
        log.debug("Request to update Sell : {}", sellDTO);
        Sell sell = sellMapper.toEntity(sellDTO);
        sell = sellRepository.save(sell);
        return sellMapper.toDto(sell);
    }

    @Override
    public Optional<SellDTO> partialUpdate(SellDTO sellDTO) {
        log.debug("Request to partially update Sell : {}", sellDTO);

        return sellRepository
            .findById(sellDTO.getId())
            .map(existingSell -> {
                sellMapper.partialUpdate(existingSell, sellDTO);

                return existingSell;
            })
            .map(sellRepository::save)
            .map(sellMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SellDTO> findAll() {
        log.debug("Request to get all Sells");
        return sellRepository.findAll().stream().map(sellMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SellDTO> findOne(Long id) {
        log.debug("Request to get Sell : {}", id);
        return sellRepository.findById(id).map(sellMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Sell : {}", id);
        sellRepository.deleteById(id);
    }
}
