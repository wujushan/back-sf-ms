/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.smartengines.common;

public class StringsMapIterator {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public StringsMapIterator(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(StringsMapIterator obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        jnisecommonJNI.delete_StringsMapIterator(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public StringsMapIterator(StringsMapIterator other) {
    this(jnisecommonJNI.new_StringsMapIterator(StringsMapIterator.getCPtr(other), other), true);
  }

  public String GetKey() {
    return jnisecommonJNI.StringsMapIterator_GetKey(swigCPtr, this);
  }

  public String GetValue() {
    return jnisecommonJNI.StringsMapIterator_GetValue(swigCPtr, this);
  }

  public boolean Equals(StringsMapIterator rvalue) {
    return jnisecommonJNI.StringsMapIterator_Equals(swigCPtr, this, StringsMapIterator.getCPtr(rvalue), rvalue);
  }

  public void Advance() {
    jnisecommonJNI.StringsMapIterator_Advance(swigCPtr, this);
  }

}
