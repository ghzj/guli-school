package io.github.ghzj.generator.aspect;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
public class ErrorCodeContextHolder {
    private static final ThreadLocal<ErrorCodeContext> ERROR_CODE_CONTEXT = new ThreadLocal<ErrorCodeContext>();

    public static void setContext(ErrorCodeContext context) {
        ERROR_CODE_CONTEXT.set(context);
    }

    public static ErrorCodeContext getContext() {
        ErrorCodeContext ctx = ERROR_CODE_CONTEXT.get();
        // 为空时，设置一个空的进去
        if (ctx == null) {
            ctx = new ErrorCodeContext();
            ERROR_CODE_CONTEXT.set(ctx);
        }
        return ctx;
    }

    public static Integer getErrorCode(String tableName) {
        ErrorCodeContext ctx = ERROR_CODE_CONTEXT.get();
        return ctx != null ? ctx.getErrorCode().get(tableName) : null;
    }

    public static void clear() {
        ERROR_CODE_CONTEXT.remove();
    }
}