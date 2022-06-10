// IFacePlugin.aidl
package com.linus.test;

// Declare any non-default types here with import statements
import com.linus.test.IFaceData;
interface IFacePlugin {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    IFaceData sendMessage(in IFaceData message);
}