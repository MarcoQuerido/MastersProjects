package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.BillingType;
import org.trebol.repository.BillingTypeRepository;
import org.trebol.service.BillingTypeService;
import org.trebol.service.dto.BillingTypeDTO;
import org.trebol.service.mapper.BillingTypeMapper;

/**
 * Service Implementation for managing {@link BillingType}.
 */
@Service
@Transactional
public class BillingTypeServiceImpl implements BillingTypeService {

    private final Logger log = LoggerFactory.getLogger(BillingTypeServiceImpl.class);

    private final BillingTypeRepository billingTypeRepository;

    private final BillingTypeMapper billingTypeMapper;

    public BillingTypeServiceImpl(BillingTypeRepository billingTypeRepository, BillingTypeMapper billingTypeMapper) {
        this.billingTypeRepository = billingTypeRepository;
        this.billingTypeMapper = billingTypeMapper;
    }

    @Override
    public BillingTypeDTO save(BillingTypeDTO billingTypeDTO) {
        log.debug("Request to save BillingType : {}", billingTypeDTO);
        BillingType billingType = billingTypeMapper.toEntity(billingTypeDTO);
        billingType = billingTypeRepository.save(billingType);
        return billingTypeMapper.toDto(billingType);
    }

    @Override
    public BillingTypeDTO update(BillingTypeDTO billingTypeDTO) {
        log.debug("Request to update BillingType : {}", billingTypeDTO);
        BillingType billingType = billingTypeMapper.toEntity(billingTypeDTO);
        billingType = billingTypeRepository.save(billingType);
        return billingTypeMapper.toDto(billingType);
    }

    @Override
    public Optional<BillingTypeDTO> partialUpdate(BillingTypeDTO billingTypeDTO) {
        log.debug("Request to partially update BillingType : {}", billingTypeDTO);

        return billingTypeRepository
            .findById(billingTypeDTO.getId())
            .map(existingBillingType -> {
                billingTypeMapper.partialUpdate(existingBillingType, billingTypeDTO);

                return existingBillingType;
            })
            .map(billingTypeRepository::save)
            .map(billingTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BillingTypeDTO> findAll() {
        log.debug("Request to get all BillingTypes");
        return billingTypeRepository.findAll().stream().map(billingTypeMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BillingTypeDTO> findOne(Long id) {
        log.debug("Request to get BillingType : {}", id);
        return billingTypeRepository.findById(id).map(billingTypeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete BillingType : {}", id);
        billingTypeRepository.deleteById(id);
    }
}
