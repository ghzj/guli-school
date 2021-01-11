package io.github.ghzj.guli.common.constant;

import io.github.ghzj.guli.common.vo.SortingField;

/**
 * @author ghzj
 * @date 2021/1/12 21:25
 */
public enum OrderCodeEnum {

    ID_ASC(1, "id", SortingField.ORDER_ASC),
    ID_DESC(2, "id", SortingField.ORDER_DESC),
    ;
    /**
     * num
     */
    private Integer num;
    /**
     * 字段
     */
    private String field;
    /**
     * 顺序
     */
    private String order;

    OrderCodeEnum(int num, String field, String order) {
        this.num = num;
        this.field = field;
        this.order = order;
    }

    public Integer getNum() {
        return num;
    }

    public String getField() {
        return field;
    }

    public String getOrder() {
        return order;
    }

    ;

}