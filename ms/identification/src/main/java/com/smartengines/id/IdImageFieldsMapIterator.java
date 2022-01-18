/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.smartengines.id;

import com.smartengines.common.*;

public class IdImageFieldsMapIterator {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public IdImageFieldsMapIterator(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(IdImageFieldsMapIterator obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        jniidengineJNI.delete_IdImageFieldsMapIterator(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public IdImageFieldsMapIterator(IdImageFieldsMapIterator other) {
    this(jniidengineJNI.new_IdImageFieldsMapIterator(IdImageFieldsMapIterator.getCPtr(other), other), true);
  }

  public String GetKey() {
    return jniidengineJNI.IdImageFieldsMapIterator_GetKey(swigCPtr, this);
  }

  public IdImageField GetValue() {
    return new IdImageField(jniidengineJNI.IdImageFieldsMapIterator_GetValue(swigCPtr, this), false);
  }

  public boolean Equals(IdImageFieldsMapIterator rvalue) {
    return jniidengineJNI.IdImageFieldsMapIterator_Equals(swigCPtr, this, IdImageFieldsMapIterator.getCPtr(rvalue), rvalue);
  }

  public void Advance() {
    jniidengineJNI.IdImageFieldsMapIterator_Advance(swigCPtr, this);
  }

}