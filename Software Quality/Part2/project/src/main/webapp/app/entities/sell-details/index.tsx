import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import SellDetails from './sell-details';
import SellDetailsDetail from './sell-details-detail';
import SellDetailsUpdate from './sell-details-update';
import SellDetailsDeleteDialog from './sell-details-delete-dialog';

const SellDetailsRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<SellDetails />} />
    <Route path="new" element={<SellDetailsUpdate />} />
    <Route path=":id">
      <Route index element={<SellDetailsDetail />} />
      <Route path="edit" element={<SellDetailsUpdate />} />
      <Route path="delete" element={<SellDetailsDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default SellDetailsRoutes;
