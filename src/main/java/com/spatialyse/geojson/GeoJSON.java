package com.spatialyse.geojson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gwt.core.shared.GwtIncompatible;
import com.spatialyse.geojson.extra.BoundingBox;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Point.class, name = "Point"),
        @JsonSubTypes.Type(value = LineString.class, name = "LineString"),
        @JsonSubTypes.Type(value = Polygon.class, name = "Polygon"),
        @JsonSubTypes.Type(value = MultiPoint.class, name = "MultiPoint"),
        @JsonSubTypes.Type(value = MultiLineString.class, name = "MultiLineString"),
        @JsonSubTypes.Type(value = MultiPolygon.class, name = "MultiPolygon"),
        @JsonSubTypes.Type(value = Feature.class, name = "Feature"),
        @JsonSubTypes.Type(value = FeatureCollection.class, name = "FeatureCollection"),
        @JsonSubTypes.Type(value = GeometryCollection.class, name = "GeometryCollection"),
        @JsonSubTypes.Type(value = BoundingBox.class, name = "BoundingBox")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true) 
public abstract class GeoJSON implements Serializable {
	private Crs crs;
	public Crs getCrs() {
		return crs;
	}

	public void setCrs(Crs crs) {
		this.crs = crs;
	}

	public abstract <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor);

	@Override
	public String toString() {
		return "GeoJsonObject{}";
	}
}
