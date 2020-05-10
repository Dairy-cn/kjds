package com.cross.model.dish;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SelfSupportDishChooseInfo implements Serializable {

    private Long dishId;

    private String dishName;

    private Long merchantId;

    public SelfSupportDishChooseInfo(Number dishId, Object dishName, Number merchantId) {
        this.dishId = null != dishId ? dishId.longValue() : null;
        this.dishName = null != dishName ? dishName.toString() : null;
        this.merchantId = null != merchantId ? merchantId.longValue() : null;
    }
}
