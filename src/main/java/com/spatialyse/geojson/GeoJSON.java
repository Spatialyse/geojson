package com.spatialyse.geojson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes( {
        @JsonSubTypes.Type(value=Point.class, name="Point"  ),
        @JsonSubTypes.Type(value=LineString.class, name="LineString"  ),
        @JsonSubTypes.Type(value=Polygon.class, name="Polygon"  ),
        @JsonSubTypes.Type(value=MultiPoint.class, name="MultiPoint"  ),
        @JsonSubTypes.Type(value=MultiLineString.class, name="MultiLineString"  ),
        @JsonSubTypes.Type(value=MultiPolygon.class, name="MultiPolygon"  ),
        @JsonSubTypes.Type(value=Feature.class, name="Feature"  ),
        @JsonSubTypes.Type(value=FeatureCollection.class, name="FeatureCollection"  ),
        @JsonSubTypes.Type(value=GeometryCollection.class, name="GeometryCollection"  )
})
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class GeoJSON {
    //private static final ObjectMapper mapper = new ObjectMapper();

    @JsonProperty("type")
    private String type;

    @JsonCreator
    public GeoJSON() {
        setType(getClass().getSimpleName());
    }

    public String toString() {
        return null;
       /*  try {
            return mapper.writeValueAsString(this);
        } catch (JsonGenerationException e) {
            return "Unhandled exception occured when serializing this instance";
        } catch (JsonMappingException e) {
            return "Unhandled exception occured when serializing this instance";
        } catch (IOException e) {
            return "Unhandled exception occured when serializing this instance";
        } */
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
