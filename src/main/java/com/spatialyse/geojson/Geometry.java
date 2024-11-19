package com.spatialyse.geojson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spatialyse.geojson.extra.BoundingBox;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Point.class, name = "Point"),
        @JsonSubTypes.Type(value = LineString.class, name = "LineString"),
        @JsonSubTypes.Type(value = Polygon.class, name = "Polygon"),
        @JsonSubTypes.Type(value = MultiPoint.class, name = "MultiPoint"),
        @JsonSubTypes.Type(value = MultiLineString.class, name = "MultiLineString"),
        @JsonSubTypes.Type(value = MultiPolygon.class, name = "MultiPolygon"),
        @JsonSubTypes.Type(value = GeometryCollection.class, name = "GeometryCollection"),
        @JsonSubTypes.Type(value = BoundingBox.class, name = "BoundingBox")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true) 
public abstract class Geometry extends GeoJSON {
    public Geometry() {
    }
}
