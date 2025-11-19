import React from 'react';
import { Translate } from 'react-jhipster';

import MenuItem from 'app/shared/layout/menus/menu-item';

const EntitiesMenu = () => {
  return (
    <>
      {/* prettier-ignore */}
      <MenuItem icon="asterisk" to="/person">
        <Translate contentKey="global.menu.entities.person" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/product-category">
        <Translate contentKey="global.menu.entities.productCategory" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/product">
        <Translate contentKey="global.menu.entities.product" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/shipper">
        <Translate contentKey="global.menu.entities.shipper" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/sell">
        <Translate contentKey="global.menu.entities.sell" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/costumer">
        <Translate contentKey="global.menu.entities.costumer" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/payment-type">
        <Translate contentKey="global.menu.entities.paymentType" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/sell-status">
        <Translate contentKey="global.menu.entities.sellStatus" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/billing-type">
        <Translate contentKey="global.menu.entities.billingType" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/billing-company">
        <Translate contentKey="global.menu.entities.billingCompany" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/address">
        <Translate contentKey="global.menu.entities.address" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/salesperson">
        <Translate contentKey="global.menu.entities.salesperson" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/sell-details">
        <Translate contentKey="global.menu.entities.sellDetails" />
      </MenuItem>
      <MenuItem icon="asterisk" to="/customer">
        <Translate contentKey="global.menu.entities.customer" />
      </MenuItem>
      {/* jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here */}
    </>
  );
};

export default EntitiesMenu;
