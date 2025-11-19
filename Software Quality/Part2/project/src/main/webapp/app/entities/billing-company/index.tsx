import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import BillingCompany from './billing-company';
import BillingCompanyDetail from './billing-company-detail';
import BillingCompanyUpdate from './billing-company-update';
import BillingCompanyDeleteDialog from './billing-company-delete-dialog';

const BillingCompanyRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<BillingCompany />} />
    <Route path="new" element={<BillingCompanyUpdate />} />
    <Route path=":id">
      <Route index element={<BillingCompanyDetail />} />
      <Route path="edit" element={<BillingCompanyUpdate />} />
      <Route path="delete" element={<BillingCompanyDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default BillingCompanyRoutes;
