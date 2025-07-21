package com.spatialyse.geojson.gwt.deserializers;

import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonDeserializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;
import com.spatialyse.geojson.Point;

public class PointDeserializer extends JsonDeserializer<Point> {

    @Override
    public Point doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
        reader.beginObject();

        double[] coordinates = null;

        while (reader.hasNext()) {
            String name = reader.nextName();
            if ("coordinates".equals(name)) {
                reader.beginArray();
                double[] coords = new double[2];
                coords[1] = reader.nextDouble();
                coords[0] = reader.nextDouble();
                reader.endArray();
                coordinates = coords;
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return new Point(coordinates);
    }
}
