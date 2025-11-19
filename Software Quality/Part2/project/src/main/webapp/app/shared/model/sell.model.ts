import dayjs from 'dayjs';
import { ISellDetails } from 'app/shared/model/sell-details.model';
import { ICustomer } from 'app/shared/model/customer.model';
import { IPaymentType } from 'app/shared/model/payment-type.model';
import { ISellStatus } from 'app/shared/model/sell-status.model';
import { IBillingType } from 'app/shared/model/billing-type.model';
import { IBillingCompany } from 'app/shared/model/billing-company.model';
import { IAddress } from 'app/shared/model/address.model';
import { IShipper } from 'app/shared/model/shipper.model';
import { ISalesperson } from 'app/shared/model/salesperson.model';

export interface ISell {
  id?: number;
  date?: string;
  totalItems?: number;
  netValue?: number;
  transportValue?: number;
  taxesValue?: number;
  totalValue?: number;
  transactionToken?: string | null;
  details?: ISellDetails[] | null;
  costumer?: ICustomer;
  paymentType?: IPaymentType;
  status?: ISellStatus;
  billingType?: IBillingType;
  billingCompany?: IBillingCompany | null;
  billingAddress?: IAddress | null;
  shipper?: IShipper | null;
  shippingAddress?: IAddress | null;
  salesperson?: ISalesperson | null;
}

export const defaultValue: Readonly<ISell> = {};
