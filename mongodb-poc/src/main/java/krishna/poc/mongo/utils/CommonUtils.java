package krishna.poc.mongo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import krishna.poc.mongo.exception.JsonObjectConverterException;

public class CommonUtils {
    private CommonUtils(){}
    public static final ObjectMapper objectmapper = new ObjectMapper();

    public static <T> T jsonToClassObject(String json, Class<T> clazz) throws JsonObjectConverterException {
        try {
            return objectmapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new JsonObjectConverterException("Failed to convert JSON to " + clazz.getSimpleName(), e);
        }
    }

    public static String objectToString(Object obj) throws JsonProcessingException {
        return objectmapper.writeValueAsString(obj);
    }
}
