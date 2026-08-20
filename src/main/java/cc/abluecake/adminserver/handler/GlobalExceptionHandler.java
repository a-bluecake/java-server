package cc.abluecake.adminserver.handler;

import cc.abluecake.adminserver.common.Result;
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
}
