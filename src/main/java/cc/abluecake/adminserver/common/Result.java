package cc.abluecake.adminserver.common;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 全局统一返回结果封装类
 */
@Data
public class Result implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // 响应状态码
    private int code;

    // 响应提示信息
    private String msg;

    // 返回的属性
    private Object data;

    /**
     * 不带结果直接返回成功
     * @return 封装好的统一返回对象Result
     */
    public static Result success() {
        return success(200, "操作成功", null);
    }

    /**
     * 直接返回成功结果
     * @param data 返回的属性
     * @return 封装好的统一返回对象Result
     */
    public static  Result success(Object data) {
        return success(200, "操作成功", data);
    }

    /**
     * 自定义返回成功结果
     * @param code 响应状态码
     * @param msg 响应提示信息
     * @param data 返回的属性
     * @return 封装好的统一返回对象Result
     */
    public static Result success(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    /**
     * 直接返回失败信息
     * @return 封装好的统一返回对象Result
     */
    public static Result error() {
        return error(400, "操作失败", null);
    }
    /**
     * 带参数返回失败信息
     * @param msg 响应提示信息
     * @return 封装好的统一返回对象Result
     */
    public static Result error(String msg) {
        return error(400, msg, null);
    }

    /**
     * 自定义返回失败信息
     * @param code 响应状态码
     * @param msg 响应提示信息
     * @param data 返回的属性
     * @return 封装好的统一返回对象Result
     */
    public static Result error(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}