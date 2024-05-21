package fr.univrennes.istic.l2gen.station;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrixListDeserializer extends JsonDeserializer<List<Prix>> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Prix> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        String json = jsonParser.getText();
        if (json.startsWith("[")) {
            // Convertit directement la chaîne JSON en List<Prix>
            return mapper.readValue(json, new TypeReference<List<Prix>>() {
            });
        }
        return new ArrayList<>();
    }
}
