package com.spatialyse.geojson;

import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder({"type", "id", "geometry", "properties"})
public class Feature extends GeoJSON {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private Map<String, Object> properties = new HashMap<String, Object>();
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private Geometry geometry;
	private String id;

    public Feature() {
    }

    public Feature(
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Map<String,Object> properties) {
        this(null, geometry, properties);
    }

    @JsonCreator
    public Feature(
            @JsonProperty("id") String id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Map<String,Object> properties) {
        super();
        this.id = id;
        this.geometry = geometry;
        this.properties = properties;
    }

	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T getProperty(String key) {
		return (T)properties.get(key);
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
		return geoJsonObjectVisitor.visit(this);
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Feature feature = (Feature)o;
		if (properties != null ? !properties.equals(feature.properties) : feature.properties != null)
			return false;
		if (geometry != null ? !geometry.equals(feature.geometry) : feature.geometry != null)
			return false;
		return !(id != null ? !id.equals(feature.id) : feature.id != null);
	}

	@Override public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (properties != null ? properties.hashCode() : 0);
		result = 31 * result + (geometry != null ? geometry.hashCode() : 0);
		result = 31 * result + (id != null ? id.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Feature{properties=" + properties + ", geometry=" + geometry + ", id='" + id + "'}";
	}
}
