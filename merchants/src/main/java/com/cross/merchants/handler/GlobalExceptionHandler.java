package com.cross.merchants.handler;

import com.cross.utils.GsonUtils;
import com.cross.utils.R;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常捕获
 *
 * @author yk
 * @since 2019/4/24$ 15:34$
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * json转换工具
     */
    private Gson gson = GsonUtils.getInstance();

    /**
     * 定义要捕获的异常 可以多个 @ExceptionHandler({})
     *
     * @param request  request
     * @param e        exception
     * @param response response
     * @return 响应结果
     */
    @ExceptionHandler(GlobalException.class)
    public R customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value());
        GlobalException exception = (GlobalException) e;
//        ErrorResponseEntity entity = new ErrorResponseEntity();
//        entity.setCode(exception.getReturnCode());
//        entity.setMessage(exception.getReturnMessage());
        return R.error(exception.getReturnMessage());
    }

}
