/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.smartengines.id;

import com.smartengines.common.*;

public class IdTemplateSegmentationResult {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public IdTemplateSegmentationResult(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(IdTemplateSegmentationResult obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        jniidengineJNI.delete_IdTemplateSegmentationResult(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public IdTemplateSegmentationResult(boolean is_accepted, double confidence) {
    this(jniidengineJNI.new_IdTemplateSegmentationResult__SWIG_0(is_accepted, confidence), true);
  }

  public IdTemplateSegmentationResult(boolean is_accepted) {
    this(jniidengineJNI.new_IdTemplateSegmentationResult__SWIG_1(is_accepted), true);
  }

  public IdTemplateSegmentationResult() {
    this(jniidengineJNI.new_IdTemplateSegmentationResult__SWIG_2(), true);
  }

  public IdTemplateSegmentationResult(IdTemplateSegmentationResult copy) {
    this(jniidengineJNI.new_IdTemplateSegmentationResult__SWIG_3(IdTemplateSegmentationResult.getCPtr(copy), copy), true);
  }

  public boolean GetIsAccepted() {
    return jniidengineJNI.IdTemplateSegmentationResult_GetIsAccepted(swigCPtr, this);
  }

  public void SetIsAccepted(boolean is_accepted) {
    jniidengineJNI.IdTemplateSegmentationResult_SetIsAccepted(swigCPtr, this, is_accepted);
  }

  public double GetConfidence() {
    return jniidengineJNI.IdTemplateSegmentationResult_GetConfidence(swigCPtr, this);
  }

  public void SetConfidence(double confidence) {
    jniidengineJNI.IdTemplateSegmentationResult_SetConfidence(swigCPtr, this, confidence);
  }

  public int GetRawFieldsCount() {
    return jniidengineJNI.IdTemplateSegmentationResult_GetRawFieldsCount(swigCPtr, this);
  }

  public boolean HasRawField(String raw_field_name) {
    return jniidengineJNI.IdTemplateSegmentationResult_HasRawField(swigCPtr, this, raw_field_name);
  }

  public Quadrangle GetRawFieldQuadrangle(String raw_field_name) {
    return new Quadrangle(jniidengineJNI.IdTemplateSegmentationResult_GetRawFieldQuadrangle(swigCPtr, this, raw_field_name), false);
  }

  public Quadrangle GetRawFieldTemplateQuadrangle(String raw_field_name) {
    return new Quadrangle(jniidengineJNI.IdTemplateSegmentationResult_GetRawFieldTemplateQuadrangle(swigCPtr, this, raw_field_name), false);
  }

  public void SetRawFieldQuadrangles(String raw_field_name, Quadrangle quadrangle, Quadrangle template_quadrangle) {
    jniidengineJNI.IdTemplateSegmentationResult_SetRawFieldQuadrangles(swigCPtr, this, raw_field_name, Quadrangle.getCPtr(quadrangle), quadrangle, Quadrangle.getCPtr(template_quadrangle), template_quadrangle);
  }

  public void RemoveRawField(String raw_field_name) {
    jniidengineJNI.IdTemplateSegmentationResult_RemoveRawField(swigCPtr, this, raw_field_name);
  }

  public QuadranglesMapIterator RawFieldQuadranglesBegin() {
    return new QuadranglesMapIterator(jniidengineJNI.IdTemplateSegmentationResult_RawFieldQuadranglesBegin(swigCPtr, this), true);
  }

  public QuadranglesMapIterator RawFieldQuadranglesEnd() {
    return new QuadranglesMapIterator(jniidengineJNI.IdTemplateSegmentationResult_RawFieldQuadranglesEnd(swigCPtr, this), true);
  }

  public QuadranglesMapIterator RawFieldTemplateQuadranglesBegin() {
    return new QuadranglesMapIterator(jniidengineJNI.IdTemplateSegmentationResult_RawFieldTemplateQuadranglesBegin(swigCPtr, this), true);
  }

  public QuadranglesMapIterator RawFieldTemplateQuadranglesEnd() {
    return new QuadranglesMapIterator(jniidengineJNI.IdTemplateSegmentationResult_RawFieldTemplateQuadranglesEnd(swigCPtr, this), true);
  }

}
