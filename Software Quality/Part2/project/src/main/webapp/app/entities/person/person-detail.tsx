import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './person.reducer';

export const PersonDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const personEntity = useAppSelector(state => state.person.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="personDetailsHeading">
          <Translate contentKey="trebolApp.person.detail.title">Person</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="trebolApp.person.id">Id</Translate>
            </span>
          </dt>
          <dd>{personEntity.id}</dd>
          <dt>
            <span id="firstName">
              <Translate contentKey="trebolApp.person.firstName">First Name</Translate>
            </span>
          </dt>
          <dd>{personEntity.firstName}</dd>
          <dt>
            <span id="lastName">
              <Translate contentKey="trebolApp.person.lastName">Last Name</Translate>
            </span>
          </dt>
          <dd>{personEntity.lastName}</dd>
          <dt>
            <span id="idNumber">
              <Translate contentKey="trebolApp.person.idNumber">Id Number</Translate>
            </span>
          </dt>
          <dd>{personEntity.idNumber}</dd>
          <dt>
            <span id="email">
              <Translate contentKey="trebolApp.person.email">Email</Translate>
            </span>
          </dt>
          <dd>{personEntity.email}</dd>
          <dt>
            <span id="phone1">
              <Translate contentKey="trebolApp.person.phone1">Phone 1</Translate>
            </span>
          </dt>
          <dd>{personEntity.phone1}</dd>
          <dt>
            <span id="phone2">
              <Translate contentKey="trebolApp.person.phone2">Phone 2</Translate>
            </span>
          </dt>
          <dd>{personEntity.phone2}</dd>
        </dl>
        <Button tag={Link} to="/person" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/person/${personEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default PersonDetail;
