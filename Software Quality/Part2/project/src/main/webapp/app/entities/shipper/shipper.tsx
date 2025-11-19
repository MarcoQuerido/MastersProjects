import React, {useState, useEffect} from 'react';
import {Link, useLocation, useNavigate} from 'react-router-dom';
import {Button, Table} from 'reactstrap';
import {Translate} from 'react-jhipster';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';

import {APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT} from 'app/config/constants';
import {useAppDispatch, useAppSelector} from 'app/config/store';

import {IShipper} from 'app/shared/model/shipper.model';
import {getEntities} from './shipper.reducer';
import axe from 'axe-core';

export const Shipper = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const shipperList = useAppSelector(state => state.shipper.entities);
  const loading = useAppSelector(state => state.shipper.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  useEffect(() => {
    // Run Axe accessibility tests when the component renders
    axe.run(document, {}, (err, results) => {
      if (err) throw err;
      console.log("Document violations: ", results.violations);
    });
  }, []); // Empty dependency array to run the test only once, on component mount


  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="shipper-heading" data-cy="ShipperHeading">
        <Translate contentKey="trebolApp.shipper.home.title">Shippers</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading}/>{' '}
            <Translate contentKey="trebolApp.shipper.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/shipper/new" className="btn btn-primary jh-create-entity" id="jh-create-entity"
                data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus"/>
            &nbsp;
            <Translate contentKey="trebolApp.shipper.home.createLabel">Create new Shipper</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {shipperList && shipperList.length > 0 ? (
          <Table responsive>
            <thead>
            <tr>
              <th>
                <Translate contentKey="trebolApp.shipper.id">Id</Translate>
              </th>
              <th>
                <Translate contentKey="trebolApp.shipper.name">Name</Translate>
              </th>
              <th/>
            </tr>
            </thead>
            <tbody>
            {shipperList.map((shipper, i) => (
              <tr key={`entity-${i}`} data-cy="entityTable">
                <td>
                  <Button tag={Link} to={`/shipper/${shipper.id}`} color="link" size="sm">
                    {shipper.id}
                  </Button>
                </td>
                <td>{shipper.name}</td>
                <td className="text-end">
                  <div className="btn-group flex-btn-group-container">
                    <Button tag={Link} to={`/shipper/${shipper.id}`} color="info" size="sm"
                            data-cy="entityDetailsButton">
                      <FontAwesomeIcon icon="eye"/>{' '}
                      <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                    </Button>
                    <Button tag={Link} to={`/shipper/${shipper.id}/edit`} color="primary" size="sm"
                            data-cy="entityEditButton">
                      <FontAwesomeIcon icon="pencil-alt"/>{' '}
                      <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                    </Button>
                    <Button tag={Link} to={`/shipper/${shipper.id}/delete`} color="danger" size="sm"
                            data-cy="entityDeleteButton">
                      <FontAwesomeIcon icon="trash"/>{' '}
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
              <Translate contentKey="trebolApp.shipper.home.notFound">No Shippers found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default Shipper;
