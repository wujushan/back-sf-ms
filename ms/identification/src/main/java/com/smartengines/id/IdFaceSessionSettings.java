/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.smartengines.id;

import com.smartengines.common.*;

public class IdFaceSessionSettings {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public IdFaceSessionSettings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(IdFaceSessionSettings obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        jniidengineJNI.delete_IdFaceSessionSettings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public IdFaceSessionSettings Clone() {
    long cPtr = jniidengineJNI.IdFaceSessionSettings_Clone(swigCPtr, this);
    return (cPtr == 0) ? null : new IdFaceSessionSettings(cPtr, false);
  }

  public int GetOptionsCount() {
    return jniidengineJNI.IdFaceSessionSettings_GetOptionsCount(swigCPtr, this);
  }

  public String GetOption(String option_name) {
    return jniidengineJNI.IdFaceSessionSettings_GetOption(swigCPtr, this, option_name);
  }

  public boolean HasOption(String option_name) {
    return jniidengineJNI.IdFaceSessionSettings_HasOption(swigCPtr, this, option_name);
  }

  public void SetOption(String option_name, String option_value) {
    jniidengineJNI.IdFaceSessionSettings_SetOption(swigCPtr, this, option_name, option_value);
  }

  public void RemoveOption(String option_name) {
    jniidengineJNI.IdFaceSessionSettings_RemoveOption(swigCPtr, this, option_name);
  }

  public StringsMapIterator OptionsBegin() {
    return new StringsMapIterator(jniidengineJNI.IdFaceSessionSettings_OptionsBegin(swigCPtr, this), true);
  }

  public StringsMapIterator OptionsEnd() {
    return new StringsMapIterator(jniidengineJNI.IdFaceSessionSettings_OptionsEnd(swigCPtr, this), true);
  }

  public int GetSupportedLivenessInstructionsCount() {
    return jniidengineJNI.IdFaceSessionSettings_GetSupportedLivenessInstructionsCount(swigCPtr, this);
  }

  public boolean HasSupportedLivenessInstruction(String instruction) {
    return jniidengineJNI.IdFaceSessionSettings_HasSupportedLivenessInstruction(swigCPtr, this, instruction);
  }

  public String GetLivenessInstructionDescription(String instruction) {
    return jniidengineJNI.IdFaceSessionSettings_GetLivenessInstructionDescription(swigCPtr, this, instruction);
  }

  public StringsMapIterator SupportedLivenessInstructionsBegin() {
    return new StringsMapIterator(jniidengineJNI.IdFaceSessionSettings_SupportedLivenessInstructionsBegin(swigCPtr, this), true);
  }

  public StringsMapIterator SupportedLivenessInstructionsEnd() {
    return new StringsMapIterator(jniidengineJNI.IdFaceSessionSettings_SupportedLivenessInstructionsEnd(swigCPtr, this), true);
  }

}
