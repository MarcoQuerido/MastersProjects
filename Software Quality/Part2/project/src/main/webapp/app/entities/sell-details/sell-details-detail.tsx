import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './sell-details.reducer';

export const SellDetailsDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const sellDetailsEntity = useAppSelector(state => state.sellDetails.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="sellDetailsDetailsHeading">
          <Translate contentKey="trebolApp.sellDetails.detail.title">SellDetails</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="trebolApp.sellDetails.id">Id</Translate>
            </span>
          </dt>
          <dd>{sellDetailsEntity.id}</dd>
          <dt>
            <span id="units">
              <Translate contentKey="trebolApp.sellDetails.units">Units</Translate>
            </span>
          </dt>
          <dd>{sellDetailsEntity.units}</dd>
          <dt>
            <span id="unitValue">
              <Translate contentKey="trebolApp.sellDetails.unitValue">Unit Value</Translate>
            </span>
          </dt>
          <dd>{sellDetailsEntity.unitValue}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="trebolApp.sellDetails.description">Description</Translate>
            </span>
          </dt>
          <dd>{sellDetailsEntity.description}</dd>
          <dt>
            <Translate contentKey="trebolApp.sellDetails.product">Product</Translate>
          </dt>
          <dd>{sellDetailsEntity.product ? sellDetailsEntity.product.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sellDetails.sell">Sell</Translate>
          </dt>
          <dd>{sellDetailsEntity.sell ? sellDetailsEntity.sell.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/sell-details" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/sell-details/${sellDetailsEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default SellDetailsDetail;
