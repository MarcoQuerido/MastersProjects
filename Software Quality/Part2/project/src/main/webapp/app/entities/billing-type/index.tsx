import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import BillingType from './billing-type';
import BillingTypeDetail from './billing-type-detail';
import BillingTypeUpdate from './billing-type-update';
import BillingTypeDeleteDialog from './billing-type-delete-dialog';

const BillingTypeRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<BillingType />} />
    <Route path="new" element={<BillingTypeUpdate />} />
    <Route path=":id">
      <Route index element={<BillingTypeDetail />} />
      <Route path="edit" element={<BillingTypeUpdate />} />
      <Route path="delete" element={<BillingTypeDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default BillingTypeRoutes;
