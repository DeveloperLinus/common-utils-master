// IFacePlugin.aidl
package com.linus.faceplugin;

// Declare any non-default types here with import statements
import com.linus.bean.IFaceData;
interface IFacePlugin {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    IFaceData sendMessage(in IFaceData message);
}