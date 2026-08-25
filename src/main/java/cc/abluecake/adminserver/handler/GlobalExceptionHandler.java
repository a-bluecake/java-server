package cc.abluecake.adminserver.handler;

import cc.abluecake.adminserver.common.Result;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotPermissionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理运行时异常
     * @param runtimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handlerException(RuntimeException runtimeException) {
        return Result.error(runtimeException.getMessage());
    }

    @ExceptionHandler(NotPermissionException.class)
    public Result handlerException(NotPermissionException notPermissionException) {
        SaHolder.getResponse().setStatus(403);
        return Result.error(notPermissionException.getMessage());
    }

}
