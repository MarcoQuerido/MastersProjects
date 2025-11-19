import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Salesperson from './salesperson';
import SalespersonDetail from './salesperson-detail';
import SalespersonUpdate from './salesperson-update';
import SalespersonDeleteDialog from './salesperson-delete-dialog';

const SalespersonRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<Salesperson />} />
    <Route path="new" element={<SalespersonUpdate />} />
    <Route path=":id">
      <Route index element={<SalespersonDetail />} />
      <Route path="edit" element={<SalespersonUpdate />} />
      <Route path="delete" element={<SalespersonDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default SalespersonRoutes;
