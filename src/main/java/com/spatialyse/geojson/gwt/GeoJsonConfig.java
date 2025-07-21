package com.spatialyse.geojson.gwt;

import com.github.nmorel.gwtjackson.client.AbstractConfiguration;
import com.spatialyse.geojson.Point;
import com.spatialyse.geojson.gwt.deserializers.PointDeserializer;

public class GeoJsonConfig extends AbstractConfiguration {
    @Override
    protected void configure() {
        type(Point.class).deserializer(PointDeserializer.class);
    }
}