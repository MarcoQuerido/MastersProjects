import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ISellDetails } from 'app/shared/model/sell-details.model';
import { getEntities } from './sell-details.reducer';

export const SellDetails = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const sellDetailsList = useAppSelector(state => state.sellDetails.entities);
  const loading = useAppSelector(state => state.sellDetails.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="sell-details-heading" data-cy="SellDetailsHeading">
        <Translate contentKey="trebolApp.sellDetails.home.title">Sell Details</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="trebolApp.sellDetails.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/sell-details/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="trebolApp.sellDetails.home.createLabel">Create new Sell Details</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {sellDetailsList && sellDetailsList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="trebolApp.sellDetails.id">Id</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sellDetails.units">Units</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sellDetails.unitValue">Unit Value</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sellDetails.description">Description</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sellDetails.product">Product</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sellDetails.sell">Sell</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {sellDetailsList.map((sellDetails, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/sell-details/${sellDetails.id}`} color="link" size="sm">
                      {sellDetails.id}
                    </Button>
                  </td>
                  <td>{sellDetails.units}</td>
                  <td>{sellDetails.unitValue}</td>
                  <td>{sellDetails.description}</td>
                  <td>{sellDetails.product ? <Link to={`/product/${sellDetails.product.id}`}>{sellDetails.product.id}</Link> : ''}</td>
                  <td>{sellDetails.sell ? <Link to={`/sell/${sellDetails.sell.id}`}>{sellDetails.sell.id}</Link> : ''}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/sell-details/${sellDetails.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/sell-details/${sellDetails.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/sell-details/${sellDetails.id}/delete`}
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
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
              <Translate contentKey="trebolApp.sellDetails.home.notFound">No Sell Details found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default SellDetails;
