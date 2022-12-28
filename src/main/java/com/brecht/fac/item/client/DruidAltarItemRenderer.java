package com.brecht.fac.item.client;

import com.brecht.fac.item.custom.DruidAltarItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DruidAltarItemRenderer extends GeoItemRenderer<DruidAltarItem> {
    public DruidAltarItemRenderer() {super(new DruidAltarItemModel());}
}
