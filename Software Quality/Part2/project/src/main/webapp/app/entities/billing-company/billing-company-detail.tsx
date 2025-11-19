import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './billing-company.reducer';

export const BillingCompanyDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const billingCompanyEntity = useAppSelector(state => state.billingCompany.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="billingCompanyDetailsHeading">
          <Translate contentKey="trebolApp.billingCompany.detail.title">BillingCompany</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="trebolApp.billingCompany.id">Id</Translate>
            </span>
          </dt>
          <dd>{billingCompanyEntity.id}</dd>
          <dt>
            <span id="idNumber">
              <Translate contentKey="trebolApp.billingCompany.idNumber">Id Number</Translate>
            </span>
          </dt>
          <dd>{billingCompanyEntity.idNumber}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="trebolApp.billingCompany.name">Name</Translate>
            </span>
          </dt>
          <dd>{billingCompanyEntity.name}</dd>
        </dl>
        <Button tag={Link} to="/billing-company" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/billing-company/${billingCompanyEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default BillingCompanyDetail;
