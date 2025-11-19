import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Costumer from './costumer';
import CostumerDetail from './costumer-detail';
import CostumerUpdate from './costumer-update';
import CostumerDeleteDialog from './costumer-delete-dialog';

const CostumerRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<Costumer />} />
    <Route path="new" element={<CostumerUpdate />} />
    <Route path=":id">
      <Route index element={<CostumerDetail />} />
      <Route path="edit" element={<CostumerUpdate />} />
      <Route path="delete" element={<CostumerDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default CostumerRoutes;
