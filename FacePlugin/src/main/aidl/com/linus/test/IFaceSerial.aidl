// IFaceSerial.aidl
package com.linus.test;

import com.linus.test.IFaceData;
import com.linus.test.IFacePlugin;

// Declare any non-default types here with import statements

interface IFaceSerial {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    IFaceData sendMessage(in IFaceData message);

    void register(in IFacePlugin message);
}