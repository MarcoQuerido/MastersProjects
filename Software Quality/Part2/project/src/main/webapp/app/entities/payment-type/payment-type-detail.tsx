import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './payment-type.reducer';

export const PaymentTypeDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const paymentTypeEntity = useAppSelector(state => state.paymentType.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="paymentTypeDetailsHeading">
          <Translate contentKey="trebolApp.paymentType.detail.title">PaymentType</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="trebolApp.paymentType.id">Id</Translate>
            </span>
          </dt>
          <dd>{paymentTypeEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="trebolApp.paymentType.name">Name</Translate>
            </span>
          </dt>
          <dd>{paymentTypeEntity.name}</dd>
        </dl>
        <Button tag={Link} to="/payment-type" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/payment-type/${paymentTypeEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default PaymentTypeDetail;
