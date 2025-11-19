import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntities as getProductCategories } from 'app/entities/product-category/product-category.reducer';
import { IProductCategory } from 'app/shared/model/product-category.model';
import { getEntity, updateEntity, createEntity, reset } from './product-category.reducer';

export const ProductCategoryUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const productCategories = useAppSelector(state => state.productCategory.entities);
  const productCategoryEntity = useAppSelector(state => state.productCategory.entity);
  const loading = useAppSelector(state => state.productCategory.loading);
  const updating = useAppSelector(state => state.productCategory.updating);
  const updateSuccess = useAppSelector(state => state.productCategory.updateSuccess);

  const handleClose = () => {
    navigate('/product-category');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getProductCategories({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...productCategoryEntity,
      ...values,
      parent: productCategories.find(it => it.id.toString() === values.parent.toString()),
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
          ...productCategoryEntity,
          parent: productCategoryEntity?.parent?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="trebolApp.productCategory.home.createOrEditLabel" data-cy="ProductCategoryCreateUpdateHeading">
            <Translate contentKey="trebolApp.productCategory.home.createOrEditLabel">Create or edit a ProductCategory</Translate>
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
                  id="product-category-id"
                  label={translate('trebolApp.productCategory.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('trebolApp.productCategory.code')}
                id="product-category-code"
                name="code"
                data-cy="code"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  minLength: { value: 1, message: translate('entity.validation.minlength', { min: 1 }) },
                  maxLength: { value: 50, message: translate('entity.validation.maxlength', { max: 50 }) },
                }}
              />
              <ValidatedField
                label={translate('trebolApp.productCategory.name')}
                id="product-category-name"
                name="name"
                data-cy="name"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  minLength: { value: 1, message: translate('entity.validation.minlength', { min: 1 }) },
                  maxLength: { value: 100, message: translate('entity.validation.maxlength', { max: 100 }) },
                }}
              />
              <ValidatedField
                id="product-category-parent"
                name="parent"
                data-cy="parent"
                label={translate('trebolApp.productCategory.parent')}
                type="select"
              >
                <option value="" key="0" />
                {productCategories
                  ? productCategories.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/product-category" replace color="info">
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

export default ProductCategoryUpdate;
