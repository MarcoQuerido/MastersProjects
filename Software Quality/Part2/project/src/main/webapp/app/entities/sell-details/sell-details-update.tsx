import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IProduct } from 'app/shared/model/product.model';
import { getEntities as getProducts } from 'app/entities/product/product.reducer';
import { ISell } from 'app/shared/model/sell.model';
import { getEntities as getSells } from 'app/entities/sell/sell.reducer';
import { ISellDetails } from 'app/shared/model/sell-details.model';
import { getEntity, updateEntity, createEntity, reset } from './sell-details.reducer';

export const SellDetailsUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const products = useAppSelector(state => state.product.entities);
  const sells = useAppSelector(state => state.sell.entities);
  const sellDetailsEntity = useAppSelector(state => state.sellDetails.entity);
  const loading = useAppSelector(state => state.sellDetails.loading);
  const updating = useAppSelector(state => state.sellDetails.updating);
  const updateSuccess = useAppSelector(state => state.sellDetails.updateSuccess);

  const handleClose = () => {
    navigate('/sell-details');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getProducts({}));
    dispatch(getSells({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...sellDetailsEntity,
      ...values,
      product: products.find(it => it.id.toString() === values.product.toString()),
      sell: sells.find(it => it.id.toString() === values.sell.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          ...sellDetailsEntity,
          product: sellDetailsEntity?.product?.id,
          sell: sellDetailsEntity?.sell?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="trebolApp.sellDetails.home.createOrEditLabel" data-cy="SellDetailsCreateUpdateHeading">
            <Translate contentKey="trebolApp.sellDetails.home.createOrEditLabel">Create or edit a SellDetails</Translate>
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
                  id="sell-details-id"
                  label={translate('trebolApp.sellDetails.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('trebolApp.sellDetails.units')}
                id="sell-details-units"
                name="units"
                data-cy="units"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sellDetails.unitValue')}
                id="sell-details-unitValue"
                name="unitValue"
                data-cy="unitValue"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('trebolApp.sellDetails.description')}
                id="sell-details-description"
                name="description"
                data-cy="description"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                id="sell-details-product"
                name="product"
                data-cy="product"
                label={translate('trebolApp.sellDetails.product')}
                type="select"
                required
              >
                <option value="" key="0" />
                {products
                  ? products.map(otherEntity => (
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
                id="sell-details-sell"
                name="sell"
                data-cy="sell"
                label={translate('trebolApp.sellDetails.sell')}
                type="select"
                required
              >
                <option value="" key="0" />
                {sells
                  ? sells.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/sell-details" replace color="info">
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

export default SellDetailsUpdate;
