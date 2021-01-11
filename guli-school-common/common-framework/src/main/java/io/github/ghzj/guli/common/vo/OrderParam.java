package io.github.ghzj.guli.common.vo;

import io.github.ghzj.guli.common.utils.OrderCodeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ghzj
 * @date 2021/1/12 21:25
 */
public class OrderParam extends PageParam {

    /**
     * 排序字段数组
     */
    private List<Integer> sorts;

    public List<Integer> getSorts() {
        return sorts;
    }

    public void setSorts(List<Integer> sorts) {
        this.sorts = sorts;
    }
}
