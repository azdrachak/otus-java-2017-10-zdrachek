package com.github.azdrachak.json;

import com.github.azdrachak.testSamples.SampleArrayClass;
import com.github.azdrachak.testSamples.SampleClass;
import com.github.azdrachak.testSamples.SampleCollectionClass;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectToJsonTest {

    @Test
    void object2jsonArray() {
        Gson gson = new Gson();
        SampleArrayClass array = new SampleArrayClass();

        String jsonArray = String.valueOf(ObjectToJson.object2json(array));
        String gString = gson.toJson(array);

        assertEquals(gString, jsonArray);
    }

    @Test
    void object2jsonCollection() {
        Gson gson = new Gson();
        SampleCollectionClass collectionClass = new SampleCollectionClass();

        String jsonArray = String.valueOf(ObjectToJson.object2json(collectionClass));
        String gString = gson.toJson(collectionClass);

        assertEquals(gString, jsonArray);
    }

    @Test
    void object2jsonSimpleObject() {
        Gson gson = new Gson();
        SampleClass sampleClass = new SampleClass();

        String jsonClass = String.valueOf(ObjectToJson.object2json(sampleClass));
        SampleClass gclass = gson.fromJson(jsonClass, SampleClass.class);

        assertEquals(sampleClass, gclass);
    }


}