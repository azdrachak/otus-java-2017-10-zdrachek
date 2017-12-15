package com.github.azdrachak;

import com.github.azdrachak.json.ObjectToJson;
import com.github.azdrachak.testSamples.SampleArrayClass;
import com.github.azdrachak.testSamples.SampleClass;
import com.github.azdrachak.testSamples.SampleCollectionClass;

public class Main {
    public static void main(String[] args) {
        System.out.println(ObjectToJson.object2json(new SampleClass()));
        System.out.println(ObjectToJson.object2json(new SampleArrayClass()));
        System.out.println(ObjectToJson.object2json(new SampleCollectionClass()));
    }
}
