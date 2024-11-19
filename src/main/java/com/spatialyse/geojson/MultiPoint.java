package com.spatialyse.geojson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MultiPoint extends Geometry {
    private double[][] coordinates;
    private double[] bbox;

    public MultiPoint() {
    }

    @JsonCreator
    public MultiPoint(@JsonProperty("coordinates") double [][] coordinates) {
        super();
        this.coordinates = coordinates;
        this.bbox = null;
    }

    public double[][] getCoordinates() {
        return coordinates;
    }

    public double[] getBbox() {
        return bbox;
    }

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}

	@Override
	public String toString() {
		return "MultiPoint{} " + super.toString();
	}
}
