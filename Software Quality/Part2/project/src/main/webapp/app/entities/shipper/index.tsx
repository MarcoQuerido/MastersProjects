import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Shipper from './shipper';
import ShipperDetail from './shipper-detail';
import ShipperUpdate from './shipper-update';
import ShipperDeleteDialog from './shipper-delete-dialog';

const ShipperRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<Shipper />} />
    <Route path="new" element={<ShipperUpdate />} />
    <Route path=":id">
      <Route index element={<ShipperDetail />} />
      <Route path="edit" element={<ShipperUpdate />} />
      <Route path="delete" element={<ShipperDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default ShipperRoutes;
