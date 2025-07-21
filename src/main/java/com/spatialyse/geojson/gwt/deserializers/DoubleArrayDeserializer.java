package com.spatialyse.geojson.gwt.deserializers;

import java.util.ArrayList;
import java.util.List;

import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonDeserializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;

public class DoubleArrayDeserializer extends JsonDeserializer<double[]> {
    @Override
    public double[] doDeserialize(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
        List<Double> values = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            values.add(reader.nextDouble());
        }
        reader.endArray();

        double[] arr = new double[values.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = values.get(i);
        }
        return arr;
    }
}
