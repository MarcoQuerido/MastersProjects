import person from 'app/entities/person/person.reducer';
import productCategory from 'app/entities/product-category/product-category.reducer';
import product from 'app/entities/product/product.reducer';
import shipper from 'app/entities/shipper/shipper.reducer';
import sell from 'app/entities/sell/sell.reducer';
import costumer from 'app/entities/costumer/costumer.reducer';
import paymentType from 'app/entities/payment-type/payment-type.reducer';
import sellStatus from 'app/entities/sell-status/sell-status.reducer';
import billingType from 'app/entities/billing-type/billing-type.reducer';
import billingCompany from 'app/entities/billing-company/billing-company.reducer';
import address from 'app/entities/address/address.reducer';
import salesperson from 'app/entities/salesperson/salesperson.reducer';
import sellDetails from 'app/entities/sell-details/sell-details.reducer';
import customer from 'app/entities/customer/customer.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  person,
  productCategory,
  product,
  shipper,
  sell,
  costumer,
  paymentType,
  sellStatus,
  billingType,
  billingCompany,
  address,
  salesperson,
  sellDetails,
  customer,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
