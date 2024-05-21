package fr.univrennes.istic.l2gen.station;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class RuptureListDeserializer extends StdDeserializer<List<Rupture>> {

    private ObjectMapper mapper = new ObjectMapper();

    protected RuptureListDeserializer() {
        super(List.class);
    }

    @Override
    public List<Rupture> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String json = p.getText();
        if (json.startsWith("[")) {
            return mapper.readValue(json, new TypeReference<List<Rupture>>() {
            });
        }
        return new ArrayList<>();
    }
}
