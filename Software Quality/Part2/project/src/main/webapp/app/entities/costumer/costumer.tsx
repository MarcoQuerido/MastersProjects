import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ICostumer } from 'app/shared/model/costumer.model';
import { getEntities } from './costumer.reducer';

export const Costumer = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const costumerList = useAppSelector(state => state.costumer.entities);
  const loading = useAppSelector(state => state.costumer.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="costumer-heading" data-cy="CostumerHeading">
        <Translate contentKey="trebolApp.costumer.home.title">Costumers</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="trebolApp.costumer.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/costumer/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="trebolApp.costumer.home.createLabel">Create new Costumer</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {costumerList && costumerList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="trebolApp.costumer.id">Id</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.costumer.person">Person</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {costumerList.map((costumer, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/costumer/${costumer.id}`} color="link" size="sm">
                      {costumer.id}
                    </Button>
                  </td>
                  <td>{costumer.person ? <Link to={`/person/${costumer.person.id}`}>{costumer.person.id}</Link> : ''}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/costumer/${costumer.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/costumer/${costumer.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/costumer/${costumer.id}/delete`} color="danger" size="sm" data-cy="entityDeleteButton">
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
              <Translate contentKey="trebolApp.costumer.home.notFound">No Costumers found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default Costumer;
