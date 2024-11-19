package com.spatialyse.geojson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MultiLineString extends Geometry {
    private List<double[][]> coordinates;
    private double[] bbox;

    public MultiLineString() {
    }

    @JsonCreator
    public MultiLineString(@JsonProperty("coordinates") List<double[][]> coordinates) {
        super();
        this.coordinates = coordinates;
        this.bbox = null;
    }

    public List<double[][]> getCoordinates() {
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
		return "MultiLineString{} " + super.toString();
	}
}
