package io.github.ghzj.guli.common.utils;

import io.github.ghzj.guli.common.constant.OrderCodeEnum;
import io.github.ghzj.guli.common.vo.OrderParam;
import io.github.ghzj.guli.common.vo.SortingField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ghzj
 * @date 2021/1/12 21:25
 */
public class OrderCodeUtil {

    private static final ConcurrentHashMap<Integer, SortingField> CODE = new ConcurrentHashMap<>();

    static {
        for (OrderCodeEnum item : OrderCodeEnum.values()) {
            CODE.put(item.getNum(), new SortingField(item.getField(),item.getOrder()));
        }
    }

    public static Collection<SortingField> getSortingFields(OrderParam orderParam){
        if (orderParam == null || orderParam.getSorts() == null || orderParam.getSorts().isEmpty()){
            return null;
        }
        ArrayList<SortingField> sortingFieldArrayList = new ArrayList<>();
        orderParam.getSorts().forEach(value -> {
            SortingField sortingField = CODE.get(value);
            if (sortingField != null){
                sortingFieldArrayList.add(sortingField);
            }
        });
        return sortingFieldArrayList;
    }

}
