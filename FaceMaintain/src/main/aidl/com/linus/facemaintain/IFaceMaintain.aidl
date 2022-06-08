// IFaceMaintain.aidl
package com.linus.facemaintain;

import com.linus.bean.IFaceData;
import com.linus.faceplugin.IFacePlugin;
// Declare any non-default types here with import statements

interface IFaceMaintain {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    IFaceData sendMessage(in IFaceData message);

    void register(in IFacePlugin message);
}