import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ISellStatus } from 'app/shared/model/sell-status.model';
import { getEntities } from './sell-status.reducer';

export const SellStatus = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const sellStatusList = useAppSelector(state => state.sellStatus.entities);
  const loading = useAppSelector(state => state.sellStatus.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="sell-status-heading" data-cy="SellStatusHeading">
        <Translate contentKey="trebolApp.sellStatus.home.title">Sell Statuses</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="trebolApp.sellStatus.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/sell-status/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="trebolApp.sellStatus.home.createLabel">Create new Sell Status</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {sellStatusList && sellStatusList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="trebolApp.sellStatus.id">Id</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sellStatus.code">Code</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.sellStatus.name">Name</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {sellStatusList.map((sellStatus, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/sell-status/${sellStatus.id}`} color="link" size="sm">
                      {sellStatus.id}
                    </Button>
                  </td>
                  <td>{sellStatus.code}</td>
                  <td>{sellStatus.name}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/sell-status/${sellStatus.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/sell-status/${sellStatus.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/sell-status/${sellStatus.id}/delete`} color="danger" size="sm" data-cy="entityDeleteButton">
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
              <Translate contentKey="trebolApp.sellStatus.home.notFound">No Sell Statuses found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default SellStatus;
