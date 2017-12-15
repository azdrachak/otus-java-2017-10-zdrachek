package com.github.azdrachak.testSamples;

public class SampleClass {
    public byte aByte = 1;
    public short aShort = 2;
    public int anInt = 3;
    public long aLong = 4;
    public float aFloat = 5.5f;
    public double aDouble= 6.6;
    public boolean aBoolean = true;
    public String string = "String";

    private int privateInt = 99;

    transient int transientInt = 33;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SampleClass that = (SampleClass) o;
        if (aBoolean != that.aBoolean) return false;
        if (aByte != that.aByte) return false;
        if (aDouble != that.aDouble) return false;
        if (aFloat != that.aFloat) return false;
        if (aLong != that.aLong) return false;
        if (aShort != that.aShort) return false;
        if (anInt != that.anInt) return false;
        if (!string.equals(that.string)) return false;
        if (privateInt != that.privateInt) return false;
        return true;
    }
}
