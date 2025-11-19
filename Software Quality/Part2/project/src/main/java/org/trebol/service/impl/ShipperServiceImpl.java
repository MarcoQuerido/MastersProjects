package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.Shipper;
import org.trebol.repository.ShipperRepository;
import org.trebol.service.ShipperService;
import org.trebol.service.dto.ShipperDTO;
import org.trebol.service.mapper.ShipperMapper;

/**
 * Service Implementation for managing {@link Shipper}.
 */
@Service
@Transactional
public class ShipperServiceImpl implements ShipperService {

    private final Logger log = LoggerFactory.getLogger(ShipperServiceImpl.class);

    private final ShipperRepository shipperRepository;

    private final ShipperMapper shipperMapper;

    public ShipperServiceImpl(ShipperRepository shipperRepository, ShipperMapper shipperMapper) {
        this.shipperRepository = shipperRepository;
        this.shipperMapper = shipperMapper;
    }

    @Override
    public ShipperDTO save(ShipperDTO shipperDTO) {
        log.debug("Request to save Shipper : {}", shipperDTO);
        Shipper shipper = shipperMapper.toEntity(shipperDTO);
        shipper = shipperRepository.save(shipper);
        return shipperMapper.toDto(shipper);
    }

    @Override
    public ShipperDTO update(ShipperDTO shipperDTO) {
        log.debug("Request to update Shipper : {}", shipperDTO);
        Shipper shipper = shipperMapper.toEntity(shipperDTO);
        shipper = shipperRepository.save(shipper);
        return shipperMapper.toDto(shipper);
    }

    @Override
    public Optional<ShipperDTO> partialUpdate(ShipperDTO shipperDTO) {
        log.debug("Request to partially update Shipper : {}", shipperDTO);

        return shipperRepository
            .findById(shipperDTO.getId())
            .map(existingShipper -> {
                shipperMapper.partialUpdate(existingShipper, shipperDTO);

                return existingShipper;
            })
            .map(shipperRepository::save)
            .map(shipperMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShipperDTO> findAll() {
        log.debug("Request to get all Shippers");
        return shipperRepository.findAll().stream().map(shipperMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ShipperDTO> findOne(Long id) {
        log.debug("Request to get Shipper : {}", id);
        return shipperRepository.findById(id).map(shipperMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Shipper : {}", id);
        shipperRepository.deleteById(id);
    }
}
