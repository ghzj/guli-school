package io.renren.entity.context;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
public class ErrorCodeContext {
    private ConcurrentHashMap<String, Integer> errorCode;

    public ConcurrentHashMap<String, Integer> getErrorCode() {
        return errorCode;
    }

    public ErrorCodeContext setErrorCode(ConcurrentHashMap<String, Integer> errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
