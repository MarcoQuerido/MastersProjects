import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IPerson } from 'app/shared/model/person.model';
import { getEntities as getPeople } from 'app/entities/person/person.reducer';
import { ISalesperson } from 'app/shared/model/salesperson.model';
import { getEntity, updateEntity, createEntity, reset } from './salesperson.reducer';

export const SalespersonUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const people = useAppSelector(state => state.person.entities);
  const salespersonEntity = useAppSelector(state => state.salesperson.entity);
  const loading = useAppSelector(state => state.salesperson.loading);
  const updating = useAppSelector(state => state.salesperson.updating);
  const updateSuccess = useAppSelector(state => state.salesperson.updateSuccess);

  const handleClose = () => {
    navigate('/salesperson');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getPeople({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...salespersonEntity,
      ...values,
      person: people.find(it => it.id.toString() === values.person.toString()),
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
          ...salespersonEntity,
          person: salespersonEntity?.person?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="trebolApp.salesperson.home.createOrEditLabel" data-cy="SalespersonCreateUpdateHeading">
            <Translate contentKey="trebolApp.salesperson.home.createOrEditLabel">Create or edit a Salesperson</Translate>
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
                  id="salesperson-id"
                  label={translate('trebolApp.salesperson.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                id="salesperson-person"
                name="person"
                data-cy="person"
                label={translate('trebolApp.salesperson.person')}
                type="select"
                required
              >
                <option value="" key="0" />
                {people
                  ? people.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/salesperson" replace color="info">
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

export default SalespersonUpdate;
