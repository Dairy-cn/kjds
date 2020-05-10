package com.cross.model.message;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 *消息模板详细内容
 * added by wy at 20191031
 * */
public class MsgContentDataVM  implements Serializable {

    @ApiModelProperty(value = "传输的key")
    private String keys;

    @ApiModelProperty(value = "封装的数据")
    private String values;

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgContentDataVM that = (MsgContentDataVM) o;
        return Objects.equals(keys, that.keys) &&
            Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keys, values);
    }

    @Override
    public String toString() {
        return "MsgContentDataVM{" +
            "keys='" + keys + '\'' +
            ", values='" + values + '\'' +
            '}';
    }
}
