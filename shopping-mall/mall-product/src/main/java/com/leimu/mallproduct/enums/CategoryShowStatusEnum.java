package com.leimu.mallproduct.enums;

import lombok.Getter;

@Getter
public enum CategoryShowStatusEnum {

    NO_SHOW(0),

    SHOW(1);

    private final int value;

    CategoryShowStatusEnum(int value) {
        this.value = value;
    }

}
