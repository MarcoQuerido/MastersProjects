import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ICustomer } from 'app/shared/model/customer.model';
import { getEntities as getCustomers } from 'app/entities/customer/customer.reducer';
import { IPaymentType } from 'app/shared/model/payment-type.model';
import { getEntities as getPaymentTypes } from 'app/entities/payment-type/payment-type.reducer';
import { ISellStatus } from 'app/shared/model/sell-status.model';
import { getEntities as getSellStatuses } from 'app/entities/sell-status/sell-status.reducer';
import { IBillingType } from 'app/shared/model/billing-type.model';
import { getEntities as getBillingTypes } from 'app/entities/billing-type/billing-type.reducer';
import { IBillingCompany } from 'app/shared/model/billing-company.model';
import { getEntities as getBillingCompanies } from 'app/entities/billing-company/billing-company.reducer';
import { IAddress } from 'app/shared/model/address.model';
import { getEntities as getAddresses } from 'app/entities/address/address.reducer';
import { IShipper } from 'app/shared/model/shipper.model';
import { getEntities as getShippers } from 'app/entities/shipper/shipper.reducer';
import { ISalesperson } from 'app/shared/model/salesperson.model';
import { getEntities as getSalespeople } from 'app/entities/salesperson/salesperson.reducer';
import { ISell } from 'app/shared/model/sell.model';
import { getEntity, updateEntity, createEntity, reset } from './sell.reducer';

export const SellUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const customers = useAppSelector(state => state.customer.entities);
  const paymentTypes = useAppSelector(state => state.paymentType.entities);
  const sellStatuses = useAppSelector(state => state.sellStatus.entities);
  const billingTypes = useAppSelector(state => state.billingType.entities);
  const billingCompanies = useAppSelector(state => state.billingCompany.entities);
  const addresses = useAppSelector(state => state.address.entities);
  const shippers = useAppSelector(state => state.shipper.entities);
  const salespeople = useAppSelector(state => state.salesperson.entities);
  const sellEntity = useAppSelector(state => state.sell.entity);
  const loading = useAppSelector(state => state.sell.loading);
  const updating = useAppSelector(state => state.sell.updating);
  const updateSuccess = useAppSelector(state => state.sell.updateSuccess);

  const handleClose = () => {
    navigate('/sell');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getCustomers({}));
    dispatch(getPaymentTypes({}));
    dispatch(getSellStatuses({}));
    dispatch(getBillingTypes({}));
    dispatch(getBillingCompanies({}));
    dispatch(getAddresses({}));
    dispatch(getShippers({}));
    dispatch(getSalespeople({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    values.date = convertDateTimeToServer(values.date);

    const entity = {
      ...sellEntity,
      ...values,
      costumer: customers.find(it => it.id.toString() === values.costumer.toString()),
      paymentType: paymentTypes.find(it => it.id.toString() === values.paymentType.toString()),
      status: sellStatuses.find(it => it.id.toString() === values.status.toString()),
      billingType: billingTypes.find(it => it.id.toString() === values.billingType.toString()),
      billingCompany: billingCompanies.find(it => it.id.toString() === values.billingCompany.toString()),
      billingAddress: addresses.find(it => it.id.toString() === values.billingAddress.toString()),
      shippingAddress: addresses.find(it => it.id.toString() === values.shippingAddress.toString()),
      shipper: shippers.find(it => it.id.toString() === values.shipper.toString()),
      salesperson: salespeople.find(it => it.id.toString() === values.salesperson.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          date: displayDefaultDateTime(),
        }
      : {
          ...sellEntity,
          date: convertDateTimeFromServer(sellEntity.date),
          costumer: sellEntity?.costumer?.id,
          paymentType: sellEntity?.paymentType?.id,
          status: sellEntity?.status?.id,
          billingType: sellEntity?.billingType?.id,
          billingCompany: sellEntity?.billingCompany?.id,
          billingAddress: sellEntity?.billingAddress?.id,
          shipper: sellEntity?.shipper?.id,
          shippingAddress: sellEntity?.shippingAddress?.id,
          salesperson: sellEntity?.salesperson?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="trebolApp.sell.home.createOrEditLabel" data-cy="SellCreateUpdateHeading">
            <Translate contentKey="trebolApp.sell.home.createOrEditLabel">Create or edit a Sell</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="sell-id"
                  label={translate('trebolApp.sell.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('trebolApp.sell.date')}
                id="sell-date"
                name="date"
                data-cy="date"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sell.totalItems')}
                id="sell-totalItems"
                name="totalItems"
                data-cy="totalItems"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sell.netValue')}
                id="sell-netValue"
                name="netValue"
                data-cy="netValue"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sell.transportValue')}
                id="sell-transportValue"
                name="transportValue"
                data-cy="transportValue"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sell.taxesValue')}
                id="sell-taxesValue"
                name="taxesValue"
                data-cy="taxesValue"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sell.totalValue')}
                id="sell-totalValue"
                name="totalValue"
                data-cy="totalValue"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sell.transactionToken')}
                id="sell-transactionToken"
                name="transactionToken"
                data-cy="transactionToken"
                type="text"
                validate={{
                  minLength: { value: 64, message: translate('entity.validation.minlength', { min: 64 }) },
                  maxLength: { value: 64, message: translate('entity.validation.maxlength', { max: 64 }) },
                }}
              />
              <ValidatedField
                id="sell-costumer"
                name="costumer"
                data-cy="costumer"
                label={translate('trebolApp.sell.costumer')}
                type="select"
                required
              >
                <option value="" key="0" />
                {customers
                  ? customers.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                id="sell-paymentType"
                name="paymentType"
                data-cy="paymentType"
                label={translate('trebolApp.sell.paymentType')}
                type="select"
                required
              >
                <option value="" key="0" />
                {paymentTypes
                  ? paymentTypes.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                id="sell-status"
                name="status"
                data-cy="status"
                label={translate('trebolApp.sell.status')}
                type="select"
                required
              >
                <option value="" key="0" />
                {sellStatuses
                  ? sellStatuses.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                id="sell-billingType"
                name="billingType"
                data-cy="billingType"
                label={translate('trebolApp.sell.billingType')}
                type="select"
                required
              >
                <option value="" key="0" />
                {billingTypes
                  ? billingTypes.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                id="sell-billingCompany"
                name="billingCompany"
                data-cy="billingCompany"
                label={translate('trebolApp.sell.billingCompany')}
                type="select"
              >
                <option value="" key="0" />
                {billingCompanies
                  ? billingCompanies.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField
                id="sell-billingAddress"
                name="billingAddress"
                data-cy="billingAddress"
                label={translate('trebolApp.sell.billingAddress')}
                type="select"
              >
                <option value="" key="0" />
                {addresses
                  ? addresses.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField id="sell-shipper" name="shipper" data-cy="shipper" label={translate('trebolApp.sell.shipper')} type="select">
                <option value="" key="0" />
                {shippers
                  ? shippers.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField
                id="sell-shippingAddress"
                name="shippingAddress"
                data-cy="shippingAddress"
                label={translate('trebolApp.sell.shippingAddress')}
                type="select"
              >
                <option value="" key="0" />
                {addresses
                  ? addresses.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField
                id="sell-salesperson"
                name="salesperson"
                data-cy="salesperson"
                label={translate('trebolApp.sell.salesperson')}
                type="select"
              >
                <option value="" key="0" />
                {salespeople
                  ? salespeople.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/sell" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default SellUpdate;
