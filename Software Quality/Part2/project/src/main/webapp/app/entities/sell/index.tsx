import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Sell from './sell';
import SellDetail from './sell-detail';
import SellUpdate from './sell-update';
import SellDeleteDialog from './sell-delete-dialog';

const SellRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<Sell />} />
    <Route path="new" element={<SellUpdate />} />
    <Route path=":id">
      <Route index element={<SellDetail />} />
      <Route path="edit" element={<SellUpdate />} />
      <Route path="delete" element={<SellDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default SellRoutes;
