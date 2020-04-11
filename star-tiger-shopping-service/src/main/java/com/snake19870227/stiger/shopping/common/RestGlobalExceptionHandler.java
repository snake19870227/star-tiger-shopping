package com.snake19870227.stiger.shopping.common;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import com.snake19870227.stiger.web.exception.GlobalExceptionHandler;
import com.snake19870227.stiger.web.exception.PostWebErrorHandler;
import com.snake19870227.stiger.web.restful.RestResponse;
import com.snake19870227.stiger.web.restful.RestResponseBuilder;
import com.snake19870227.stiger.web.view.ModelAndViewBuilder;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
@ControllerAdvice
public class RestGlobalExceptionHandler extends GlobalExceptionHandler {

    public RestGlobalExceptionHandler(ObjectProvider<PostWebErrorHandler> postExceptionHandlerProvider) {
        super(postExceptionHandlerProvider);
    }

    @ExceptionHandler({
            BindException.class,
            MethodArgumentNotValidException.class
    })
    public ModelAndView bindException(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Exception ex,
                                      HandlerMethod handlerMethod) {

        RestResponse.DefaultRestResponse restResponse = null;

        String errorMessages = getErrorMessages(ex);

        if (StrUtil.isNotBlank(errorMessages)) {
            restResponse = RestResponseBuilder.createDefaultRestResp(false, "4000", new String[]{errorMessages}, null);
        } else {
            restResponse = RestResponseBuilder.createFailureDefaultRestResp(ex, null);
        }

        ModelAndView mv = ModelAndViewBuilder.buildToJsonResponseBody(restResponse);

        updateHttpStatusCode(response);

        doPostWebErrorHandler(request, response, ex, handlerMethod, mv);

        return mv;
    }

    private String getErrorMessages(Exception ex) {

        StringBuilder messages = new StringBuilder();

        BindingResult result = extractBindingResult(ex);

        if (result == null || !result.hasErrors()) {
            return null;
        }

        result.getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                messages.append("'").append(((FieldError) error).getField()).append("'");
            }
            messages.append(error.getDefaultMessage()).append("; ");
        });

        return messages.toString();
    }

    private BindingResult extractBindingResult(Throwable error) {
        if (error instanceof BindingResult) {
            return (BindingResult) error;
        }
        if (error instanceof MethodArgumentNotValidException) {
            return ((MethodArgumentNotValidException) error).getBindingResult();
        }
        return null;
    }
}
