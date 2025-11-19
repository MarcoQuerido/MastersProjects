import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IBillingCompany } from 'app/shared/model/billing-company.model';
import { getEntities } from './billing-company.reducer';

export const BillingCompany = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const billingCompanyList = useAppSelector(state => state.billingCompany.entities);
  const loading = useAppSelector(state => state.billingCompany.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="billing-company-heading" data-cy="BillingCompanyHeading">
        <Translate contentKey="trebolApp.billingCompany.home.title">Billing Companies</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="trebolApp.billingCompany.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/billing-company/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="trebolApp.billingCompany.home.createLabel">Create new Billing Company</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {billingCompanyList && billingCompanyList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="trebolApp.billingCompany.id">Id</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.billingCompany.idNumber">Id Number</Translate>
                </th>
                <th>
                  <Translate contentKey="trebolApp.billingCompany.name">Name</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {billingCompanyList.map((billingCompany, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/billing-company/${billingCompany.id}`} color="link" size="sm">
                      {billingCompany.id}
                    </Button>
                  </td>
                  <td>{billingCompany.idNumber}</td>
                  <td>{billingCompany.name}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/billing-company/${billingCompany.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/billing-company/${billingCompany.id}/edit`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/billing-company/${billingCompany.id}/delete`}
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
              <Translate contentKey="trebolApp.billingCompany.home.notFound">No Billing Companies found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default BillingCompany;
