package com.github.azdrachak.json;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class ObjectToJson {
    public static String object2json(Object object) {
        return jsonObjectBuilder(object).build().toString();
    }

    private static JsonObjectBuilder jsonObjectBuilder(Object object) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        List<Field> fields = getFields(object.getClass());

        for (Field field : fields) {
            String fieldName = field.getName();

            Object obj = ReflectionHelper.getFieldValue(object, fieldName);

            Class type = field.getType();

            if (Modifier.isTransient(field.getModifiers())) continue;

            if (obj == null) {
                builder.addNull(fieldName);
            } else if (type.isPrimitive()) {
                if (obj instanceof Byte) builder.add(fieldName, (byte) obj);
                else if (obj instanceof Short) builder.add(fieldName, (short) obj);
                else if (obj instanceof Integer) builder.add(fieldName, (int) obj);
                else if (obj instanceof Long) builder.add(fieldName, (long) obj);
                else if (obj instanceof Float) builder.add(fieldName, (float) obj);
                else if (obj instanceof Double) builder.add(fieldName, (double) obj);
                else if (obj instanceof Boolean) builder.add(fieldName, (boolean) obj);
                else if (obj instanceof Character) builder.add(fieldName, (char) obj);
            } else if (obj instanceof String) builder.add(fieldName, (String) obj);
            else if (type.isArray()) builder.add(fieldName, arrayBuilder((Object[]) obj));
            else if (Collection.class.isAssignableFrom(type)) {
                obj = ((Collection) obj).toArray();
                builder.add(fieldName, arrayBuilder((Object[]) obj));
            } else builder.add(fieldName, object2json(obj));

        }
        return builder;
    }

    private static List<Field> getFields(Class<?> type) {
        return new ArrayList<>(Arrays.asList(type.getDeclaredFields()));
    }

    private static JsonArrayBuilder arrayBuilder(Object[] arr) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Object o : arr) {
            builder.add(jsonObjectBuilder(o));
        }
        return builder;
    }
}
