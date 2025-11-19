import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './sell-status.reducer';

export const SellStatusDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const sellStatusEntity = useAppSelector(state => state.sellStatus.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="sellStatusDetailsHeading">
          <Translate contentKey="trebolApp.sellStatus.detail.title">SellStatus</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="trebolApp.sellStatus.id">Id</Translate>
            </span>
          </dt>
          <dd>{sellStatusEntity.id}</dd>
          <dt>
            <span id="code">
              <Translate contentKey="trebolApp.sellStatus.code">Code</Translate>
            </span>
          </dt>
          <dd>{sellStatusEntity.code}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="trebolApp.sellStatus.name">Name</Translate>
            </span>
          </dt>
          <dd>{sellStatusEntity.name}</dd>
        </dl>
        <Button tag={Link} to="/sell-status" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/sell-status/${sellStatusEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default SellStatusDetail;
