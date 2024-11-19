package com.spatialyse.geojson.extra;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spatialyse.geojson.GeoJsonObjectVisitor;
import com.spatialyse.geojson.Geometry;
import com.spatialyse.geojson.Point;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BoundingBox extends Geometry {
    private final Point northWest;
    private final Point southEast;

    @JsonCreator
    public BoundingBox(@JsonProperty("northWest") Point northWest, @JsonProperty("southEast") Point southEast) {
        super();
        this.northWest = northWest;
        this.southEast = southEast;
    }

    /* public BoundingBox() {
        //super();
        this.northWest = northWest;
        this.southEast = southEast;
    } */

    public Point getNorthWest() {
        return northWest;
    }

    public Point getSouthEast() {
        return southEast;
    }

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}
}
