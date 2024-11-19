package com.spatialyse.geojson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Point extends Geometry {
    private double[] coordinates;
    private double[] bbox;

    public Point() {
    }

    @JsonCreator
    public Point(@JsonProperty("coordinates") double[] coordinates) {
        super();
        this.coordinates = coordinates;
        this.bbox = null;
    }

    public Point(double lng, double lat) {
        this(new double[] { lng, lat });
    }

    public double[] getCoordinates() {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Point point = (Point) o;
        return !(coordinates != null ? !coordinates.equals(point.coordinates) : point.coordinates != null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" + "coordinates=" + coordinates + "} " + super.toString();
    }
}
