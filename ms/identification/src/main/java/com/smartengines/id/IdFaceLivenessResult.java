/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.smartengines.id;

import com.smartengines.common.*;

public class IdFaceLivenessResult {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public IdFaceLivenessResult(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(IdFaceLivenessResult obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        jniidengineJNI.delete_IdFaceLivenessResult(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public IdFaceLivenessResult(double liveness_estimation) {
    this(jniidengineJNI.new_IdFaceLivenessResult__SWIG_0(liveness_estimation), true);
  }

  public IdFaceLivenessResult() {
    this(jniidengineJNI.new_IdFaceLivenessResult__SWIG_1(), true);
  }

  public IdFaceLivenessResult(IdFaceLivenessResult copy) {
    this(jniidengineJNI.new_IdFaceLivenessResult__SWIG_2(IdFaceLivenessResult.getCPtr(copy), copy), true);
  }

  public double GetLivenessEstimation() {
    return jniidengineJNI.IdFaceLivenessResult_GetLivenessEstimation(swigCPtr, this);
  }

  public void SetLivenessEstimation(double liveness_estimation) {
    jniidengineJNI.IdFaceLivenessResult_SetLivenessEstimation(swigCPtr, this, liveness_estimation);
  }

  public void SetLivenessInstruction(String instruction) {
    jniidengineJNI.IdFaceLivenessResult_SetLivenessInstruction(swigCPtr, this, instruction);
  }

  public String GetLivenessInstruction() {
    return jniidengineJNI.IdFaceLivenessResult_GetLivenessInstruction(swigCPtr, this);
  }

}
