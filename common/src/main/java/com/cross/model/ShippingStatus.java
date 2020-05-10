package com.cross.model;

/**
 * The ShippingStatus enumeration.
 *
 * 0：待调度
  20：已接单
  30：已取货
  50：已送达
  99：已取消
 */
public enum ShippingStatus {
    WAIT_CALL, TAKING, RECEIVED, SERVICE, CANCEL, EXCEPTION
}
