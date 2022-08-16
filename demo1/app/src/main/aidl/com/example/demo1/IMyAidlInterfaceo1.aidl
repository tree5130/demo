// IMyAidlInterfaceo1.aidl
package com.example.demo1;

// Declare any non-default types here with import statements
import com.example.demo1.People01;
interface IMyAidlInterfaceo1 {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    List<People01> getPeople();
    void addPeople(in People01 people);
}