/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.smartengines.id;

import com.smartengines.common.*;

public class IdCheckField {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public IdCheckField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(IdCheckField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        jniidengineJNI.delete_IdCheckField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public IdCheckField() {
    this(jniidengineJNI.new_IdCheckField__SWIG_0(), true);
  }

  public IdCheckField(String name, IdCheckStatus value, boolean is_accepted, double confidence) {
    this(jniidengineJNI.new_IdCheckField__SWIG_1(name, value.swigValue(), is_accepted, confidence), true);
  }

  public IdCheckField(String name, IdCheckStatus value, boolean is_accepted) {
    this(jniidengineJNI.new_IdCheckField__SWIG_2(name, value.swigValue(), is_accepted), true);
  }

  public IdCheckField(String name, IdCheckStatus value) {
    this(jniidengineJNI.new_IdCheckField__SWIG_3(name, value.swigValue()), true);
  }

  public IdCheckField(IdCheckField copy) {
    this(jniidengineJNI.new_IdCheckField__SWIG_4(IdCheckField.getCPtr(copy), copy), true);
  }

  public String GetName() {
    return jniidengineJNI.IdCheckField_GetName(swigCPtr, this);
  }

  public void SetName(String name) {
    jniidengineJNI.IdCheckField_SetName(swigCPtr, this, name);
  }

  public IdCheckStatus GetValue() {
    return IdCheckStatus.swigToEnum(jniidengineJNI.IdCheckField_GetValue(swigCPtr, this));
  }

  public void SetValue(IdCheckStatus value) {
    jniidengineJNI.IdCheckField_SetValue(swigCPtr, this, value.swigValue());
  }

  public IdBaseFieldInfo GetBaseFieldInfo() {
    return new IdBaseFieldInfo(jniidengineJNI.IdCheckField_GetBaseFieldInfo(swigCPtr, this), false);
  }

  public IdBaseFieldInfo GetMutableBaseFieldInfo() {
    return new IdBaseFieldInfo(jniidengineJNI.IdCheckField_GetMutableBaseFieldInfo(swigCPtr, this), false);
  }

}