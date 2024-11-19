package com.spatialyse.geojson.gwt;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.github.nmorel.gwtjackson.client.exception.JsonDeserializationException;
import com.github.nmorel.gwtjackson.client.exception.JsonSerializationException;
import com.google.gwt.core.client.GWT;
import com.spatialyse.geojson.GeoJSON;

public class GwtUtils {
    public static interface GeoJsonModelMapper extends ObjectMapper<GeoJSON> {}
    public static GeoJsonModelMapper GEOJSON_MAPPER = GWT.create(GeoJsonModelMapper.class);

    protected GwtUtils() {
    }

    public static String serialize(GeoJSON geoJson) throws JsonSerializationException {
        return GEOJSON_MAPPER.write(geoJson);
    }

    public static GeoJSON serialize(String geoJson) throws JsonDeserializationException {
        return GEOJSON_MAPPER.read(geoJson);
    }
}
