package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.BillingCompany;
import org.trebol.repository.BillingCompanyRepository;
import org.trebol.service.BillingCompanyService;
import org.trebol.service.dto.BillingCompanyDTO;
import org.trebol.service.mapper.BillingCompanyMapper;

/**
 * Service Implementation for managing {@link BillingCompany}.
 */
@Service
@Transactional
public class BillingCompanyServiceImpl implements BillingCompanyService {

    private final Logger log = LoggerFactory.getLogger(BillingCompanyServiceImpl.class);

    private final BillingCompanyRepository billingCompanyRepository;

    private final BillingCompanyMapper billingCompanyMapper;

    public BillingCompanyServiceImpl(BillingCompanyRepository billingCompanyRepository, BillingCompanyMapper billingCompanyMapper) {
        this.billingCompanyRepository = billingCompanyRepository;
        this.billingCompanyMapper = billingCompanyMapper;
    }

    @Override
    public BillingCompanyDTO save(BillingCompanyDTO billingCompanyDTO) {
        log.debug("Request to save BillingCompany : {}", billingCompanyDTO);
        BillingCompany billingCompany = billingCompanyMapper.toEntity(billingCompanyDTO);
        billingCompany = billingCompanyRepository.save(billingCompany);
        return billingCompanyMapper.toDto(billingCompany);
    }

    @Override
    public BillingCompanyDTO update(BillingCompanyDTO billingCompanyDTO) {
        log.debug("Request to update BillingCompany : {}", billingCompanyDTO);
        BillingCompany billingCompany = billingCompanyMapper.toEntity(billingCompanyDTO);
        billingCompany = billingCompanyRepository.save(billingCompany);
        return billingCompanyMapper.toDto(billingCompany);
    }

    @Override
    public Optional<BillingCompanyDTO> partialUpdate(BillingCompanyDTO billingCompanyDTO) {
        log.debug("Request to partially update BillingCompany : {}", billingCompanyDTO);

        return billingCompanyRepository
            .findById(billingCompanyDTO.getId())
            .map(existingBillingCompany -> {
                billingCompanyMapper.partialUpdate(existingBillingCompany, billingCompanyDTO);

                return existingBillingCompany;
            })
            .map(billingCompanyRepository::save)
            .map(billingCompanyMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BillingCompanyDTO> findAll() {
        log.debug("Request to get all BillingCompanies");
        return billingCompanyRepository
            .findAll()
            .stream()
            .map(billingCompanyMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BillingCompanyDTO> findOne(Long id) {
        log.debug("Request to get BillingCompany : {}", id);
        return billingCompanyRepository.findById(id).map(billingCompanyMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete BillingCompany : {}", id);
        billingCompanyRepository.deleteById(id);
    }
}
