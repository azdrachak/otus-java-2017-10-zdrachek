package com.github.azdrachak.json;

import javax.json.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class ObjectToJson {
    public static JsonObject object2json(Object object) {
        return jsonObjectBuilder(object).build();
    }

    private static JsonObjectBuilder jsonObjectBuilder(Object object) {
        JsonObjectBuilder builder = Json.createObjectBuilder();

        List<Field> fields = getFields(object.getClass());

        for (Field field : fields) {
            String fieldName = field.getName();

            Object obj = ReflectionHelper.getFieldValue(object, fieldName);

            Class type = field.getType();

            if (Modifier.isTransient(field.getModifiers())) continue;

            addObjectToBuilder(obj, fieldName, type, builder);

        }
        return builder;
    }

    private static List<Field> getFields(Class<?> type) {
        return new ArrayList<>(Arrays.asList(type.getDeclaredFields()));
    }

    private static JsonArrayBuilder arrayBuilder(Object array) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (int i = 0; i < Array.getLength(array); i++) {
            Object object = Array.get(array, i);
            if (isFiniteObject(object)) {
                if (object instanceof Byte) builder.add((byte) object);
                else if (object instanceof Short) builder.add((short) object);
                else if (object instanceof Integer) builder.add((int) object);
                else if (object instanceof Long) builder.add((long) object);
                else if (object instanceof Float) builder.add((float) object);
                else if (object instanceof Double) builder.add((double) object);
                else if (object instanceof Boolean) builder.add((boolean) object);
                else if (object instanceof Character || object instanceof String) builder.add(object.toString());
            } else {
                builder.add(jsonObjectBuilder(object));
            }
        }
        return builder;
    }

    private static boolean isFiniteObject(Object obj) {
        return obj instanceof Number
                || obj instanceof Character
                || obj instanceof Boolean
                || obj instanceof String;
    }

    private static void addObjectToBuilder(Object obj, String fieldName, Class type, JsonObjectBuilder builder) {
        if (obj == null) builder.addNull(fieldName);
        else if (isFiniteObject(obj)) {
            if (obj instanceof Byte) builder.add(fieldName, (byte) obj);
            else if (obj instanceof Short) builder.add(fieldName, (short) obj);
            else if (obj instanceof Integer) builder.add(fieldName, (int) obj);
            else if (obj instanceof Long) builder.add(fieldName, (long) obj);
            else if (obj instanceof Float) builder.add(fieldName, (float) obj);
            else if (obj instanceof Double) builder.add(fieldName, (double) obj);
            else if (obj instanceof Boolean) builder.add(fieldName, (boolean) obj);
            else if (obj instanceof Character || obj instanceof String) builder.add(fieldName, obj.toString());
        } else if (type.isArray()) builder.add(fieldName, arrayBuilder(obj));
        else if (Collection.class.isAssignableFrom(type)) {
            obj = ((Collection) obj).toArray();
            builder.add(fieldName, arrayBuilder((obj)));
        } else builder.add(fieldName, object2json(obj));
    }
}
