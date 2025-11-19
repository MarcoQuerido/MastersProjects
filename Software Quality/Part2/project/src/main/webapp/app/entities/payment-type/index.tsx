import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import PaymentType from './payment-type';
import PaymentTypeDetail from './payment-type-detail';
import PaymentTypeUpdate from './payment-type-update';
import PaymentTypeDeleteDialog from './payment-type-delete-dialog';

const PaymentTypeRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<PaymentType />} />
    <Route path="new" element={<PaymentTypeUpdate />} />
    <Route path=":id">
      <Route index element={<PaymentTypeDetail />} />
      <Route path="edit" element={<PaymentTypeUpdate />} />
      <Route path="delete" element={<PaymentTypeDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default PaymentTypeRoutes;
