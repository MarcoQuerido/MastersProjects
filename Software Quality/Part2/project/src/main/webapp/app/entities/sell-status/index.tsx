import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import SellStatus from './sell-status';
import SellStatusDetail from './sell-status-detail';
import SellStatusUpdate from './sell-status-update';
import SellStatusDeleteDialog from './sell-status-delete-dialog';

const SellStatusRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<SellStatus />} />
    <Route path="new" element={<SellStatusUpdate />} />
    <Route path=":id">
      <Route index element={<SellStatusDetail />} />
      <Route path="edit" element={<SellStatusUpdate />} />
      <Route path="delete" element={<SellStatusDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default SellStatusRoutes;
