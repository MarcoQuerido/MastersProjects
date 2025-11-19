import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ISalesperson } from 'app/shared/model/salesperson.model';
import { getEntities } from './salesperson.reducer';

export const Salesperson = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const salespersonList = useAppSelector(state => state.salesperson.entities);
  const loading = useAppSelector(state => state.salesperson.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="salesperson-heading" data-cy="SalespersonHeading">
        <Translate contentKey="trebolApp.salesperson.home.title">Salespeople</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="trebolApp.salesperson.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/salesperson/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="trebolApp.salesperson.home.createLabel">Create new Salesperson</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {salespersonList && salespersonList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="trebolApp.salesperson.id">Id</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.salesperson.person">Person</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {salespersonList.map((salesperson, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/salesperson/${salesperson.id}`} color="link" size="sm">
                      {salesperson.id}
                    </Button>
                  </td>
                  <td>{salesperson.person ? <Link to={`/person/${salesperson.person.id}`}>{salesperson.person.id}</Link> : ''}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/salesperson/${salesperson.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/salesperson/${salesperson.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/salesperson/${salesperson.id}/delete`} color="danger" size="sm" data-cy="entityDeleteButton">
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
              <Translate contentKey="trebolApp.salesperson.home.notFound">No Salespeople found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default Salesperson;
