import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Person from './person';
import ProductCategory from './product-category';
import Product from './product';
import Shipper from './shipper';
import Sell from './sell';
import Costumer from './costumer';
import PaymentType from './payment-type';
import SellStatus from './sell-status';
import BillingType from './billing-type';
import BillingCompany from './billing-company';
import Address from './address';
import Salesperson from './salesperson';
import SellDetails from './sell-details';
import Customer from './customer';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default () => {
  return (
    <div>
      <ErrorBoundaryRoutes>
        {/* prettier-ignore */}
        <Route path="person/*" element={<Person />} />
        <Route path="product-category/*" element={<ProductCategory />} />
        <Route path="product/*" element={<Product />} />
        <Route path="shipper/*" element={<Shipper />} />
        <Route path="sell/*" element={<Sell />} />
        <Route path="costumer/*" element={<Costumer />} />
        <Route path="payment-type/*" element={<PaymentType />} />
        <Route path="sell-status/*" element={<SellStatus />} />
        <Route path="billing-type/*" element={<BillingType />} />
        <Route path="billing-company/*" element={<BillingCompany />} />
        <Route path="address/*" element={<Address />} />
        <Route path="salesperson/*" element={<Salesperson />} />
        <Route path="sell-details/*" element={<SellDetails />} />
        <Route path="customer/*" element={<Customer />} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </ErrorBoundaryRoutes>
    </div>
  );
};
