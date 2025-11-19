package org.trebol.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.domain.PaymentType;
import org.trebol.repository.PaymentTypeRepository;
import org.trebol.service.PaymentTypeService;
import org.trebol.service.dto.PaymentTypeDTO;
import org.trebol.service.mapper.PaymentTypeMapper;

/**
 * Service Implementation for managing {@link PaymentType}.
 */
@Service
@Transactional
public class PaymentTypeServiceImpl implements PaymentTypeService {

    private final Logger log = LoggerFactory.getLogger(PaymentTypeServiceImpl.class);

    private final PaymentTypeRepository paymentTypeRepository;

    private final PaymentTypeMapper paymentTypeMapper;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository, PaymentTypeMapper paymentTypeMapper) {
        this.paymentTypeRepository = paymentTypeRepository;
        this.paymentTypeMapper = paymentTypeMapper;
    }

    @Override
    public PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO) {
        log.debug("Request to save PaymentType : {}", paymentTypeDTO);
        PaymentType paymentType = paymentTypeMapper.toEntity(paymentTypeDTO);
        paymentType = paymentTypeRepository.save(paymentType);
        return paymentTypeMapper.toDto(paymentType);
    }

    @Override
    public PaymentTypeDTO update(PaymentTypeDTO paymentTypeDTO) {
        log.debug("Request to update PaymentType : {}", paymentTypeDTO);
        PaymentType paymentType = paymentTypeMapper.toEntity(paymentTypeDTO);
        paymentType = paymentTypeRepository.save(paymentType);
        return paymentTypeMapper.toDto(paymentType);
    }

    @Override
    public Optional<PaymentTypeDTO> partialUpdate(PaymentTypeDTO paymentTypeDTO) {
        log.debug("Request to partially update PaymentType : {}", paymentTypeDTO);

        return paymentTypeRepository
            .findById(paymentTypeDTO.getId())
            .map(existingPaymentType -> {
                paymentTypeMapper.partialUpdate(existingPaymentType, paymentTypeDTO);

                return existingPaymentType;
            })
            .map(paymentTypeRepository::save)
            .map(paymentTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentTypeDTO> findAll() {
        log.debug("Request to get all PaymentTypes");
        return paymentTypeRepository.findAll().stream().map(paymentTypeMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTypeDTO> findOne(Long id) {
        log.debug("Request to get PaymentType : {}", id);
        return paymentTypeRepository.findById(id).map(paymentTypeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PaymentType : {}", id);
        paymentTypeRepository.deleteById(id);
    }
}
