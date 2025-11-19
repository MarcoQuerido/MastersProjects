import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './sell.reducer';

export const SellDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const sellEntity = useAppSelector(state => state.sell.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="sellDetailsHeading">
          <Translate contentKey="trebolApp.sell.detail.title">Sell</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="trebolApp.sell.id">Id</Translate>
            </span>
          </dt>
          <dd>{sellEntity.id}</dd>
          <dt>
            <span id="date">
              <Translate contentKey="trebolApp.sell.date">Date</Translate>
            </span>
          </dt>
          <dd>{sellEntity.date ? <TextFormat value={sellEntity.date} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="totalItems">
              <Translate contentKey="trebolApp.sell.totalItems">Total Items</Translate>
            </span>
          </dt>
          <dd>{sellEntity.totalItems}</dd>
          <dt>
            <span id="netValue">
              <Translate contentKey="trebolApp.sell.netValue">Net Value</Translate>
            </span>
          </dt>
          <dd>{sellEntity.netValue}</dd>
          <dt>
            <span id="transportValue">
              <Translate contentKey="trebolApp.sell.transportValue">Transport Value</Translate>
            </span>
          </dt>
          <dd>{sellEntity.transportValue}</dd>
          <dt>
            <span id="taxesValue">
              <Translate contentKey="trebolApp.sell.taxesValue">Taxes Value</Translate>
            </span>
          </dt>
          <dd>{sellEntity.taxesValue}</dd>
          <dt>
            <span id="totalValue">
              <Translate contentKey="trebolApp.sell.totalValue">Total Value</Translate>
            </span>
          </dt>
          <dd>{sellEntity.totalValue}</dd>
          <dt>
            <span id="transactionToken">
              <Translate contentKey="trebolApp.sell.transactionToken">Transaction Token</Translate>
            </span>
          </dt>
          <dd>{sellEntity.transactionToken}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.costumer">Costumer</Translate>
          </dt>
          <dd>{sellEntity.costumer ? sellEntity.costumer.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.paymentType">Payment Type</Translate>
          </dt>
          <dd>{sellEntity.paymentType ? sellEntity.paymentType.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.status">Status</Translate>
          </dt>
          <dd>{sellEntity.status ? sellEntity.status.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.billingType">Billing Type</Translate>
          </dt>
          <dd>{sellEntity.billingType ? sellEntity.billingType.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.billingCompany">Billing Company</Translate>
          </dt>
          <dd>{sellEntity.billingCompany ? sellEntity.billingCompany.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.billingAddress">Billing Address</Translate>
          </dt>
          <dd>{sellEntity.billingAddress ? sellEntity.billingAddress.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.shipper">Shipper</Translate>
          </dt>
          <dd>{sellEntity.shipper ? sellEntity.shipper.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.shippingAddress">Shipping Address</Translate>
          </dt>
          <dd>{sellEntity.shippingAddress ? sellEntity.shippingAddress.id : ''}</dd>
          <dt>
            <Translate contentKey="trebolApp.sell.salesperson">Salesperson</Translate>
          </dt>
          <dd>{sellEntity.salesperson ? sellEntity.salesperson.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/sell" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/sell/${sellEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default SellDetail;
