import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ISell } from 'app/shared/model/sell.model';
import { getEntities } from './sell.reducer';

export const Sell = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const sellList = useAppSelector(state => state.sell.entities);
  const loading = useAppSelector(state => state.sell.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="sell-heading" data-cy="SellHeading">
        <Translate contentKey="trebolApp.sell.home.title">Sells</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="trebolApp.sell.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/sell/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="trebolApp.sell.home.createLabel">Create new Sell</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {sellList && sellList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="trebolApp.sell.id">Id</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.date">Date</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.totalItems">Total Items</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.netValue">Net Value</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.transportValue">Transport Value</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.taxesValue">Taxes Value</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.totalValue">Total Value</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.transactionToken">Transaction Token</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.costumer">Costumer</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.paymentType">Payment Type</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.status">Status</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.billingType">Billing Type</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.billingCompany">Billing Company</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.billingAddress">Billing Address</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.shipper">Shipper</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.shippingAddress">Shipping Address</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sell.salesperson">Salesperson</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {sellList.map((sell, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/sell/${sell.id}`} color="link" size="sm">
                      {sell.id}
                    </Button>
                  </td>
                  <td>{sell.date ? <TextFormat type="date" value={sell.date} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>{sell.totalItems}</td>
                  <td>{sell.netValue}</td>
                  <td>{sell.transportValue}</td>
                  <td>{sell.taxesValue}</td>
                  <td>{sell.totalValue}</td>
                  <td>{sell.transactionToken}</td>
                  <td>{sell.costumer ? <Link to={`/customer/${sell.costumer.id}`}>{sell.costumer.id}</Link> : ''}</td>
                  <td>{sell.paymentType ? <Link to={`/payment-type/${sell.paymentType.id}`}>{sell.paymentType.id}</Link> : ''}</td>
                  <td>{sell.status ? <Link to={`/sell-status/${sell.status.id}`}>{sell.status.id}</Link> : ''}</td>
                  <td>{sell.billingType ? <Link to={`/billing-type/${sell.billingType.id}`}>{sell.billingType.id}</Link> : ''}</td>
                  <td>
                    {sell.billingCompany ? <Link to={`/billing-company/${sell.billingCompany.id}`}>{sell.billingCompany.id}</Link> : ''}
                  </td>
                  <td>{sell.billingAddress ? <Link to={`/address/${sell.billingAddress.id}`}>{sell.billingAddress.id}</Link> : ''}</td>
                  <td>{sell.shipper ? <Link to={`/shipper/${sell.shipper.id}`}>{sell.shipper.id}</Link> : ''}</td>
                  <td>{sell.shippingAddress ? <Link to={`/address/${sell.shippingAddress.id}`}>{sell.shippingAddress.id}</Link> : ''}</td>
                  <td>{sell.salesperson ? <Link to={`/salesperson/${sell.salesperson.id}`}>{sell.salesperson.id}</Link> : ''}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/sell/${sell.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/sell/${sell.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/sell/${sell.id}/delete`} color="danger" size="sm" data-cy="entityDeleteButton">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="trebolApp.sell.home.notFound">No Sells found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default Sell;
