
package com.client.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName GlobalDefaultExceptionHandler
 * @Description:
 * @Date 2018/6/13 19:49
 * @author wangchao
 * @version 1.0
 */

/**
 * 全局异常拦截处理类
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {


    Logger logger = LogManager.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * @param e 异常类
     * @Description: 全局异常处理方法
     * @return:
     * @Author: wangchao
     * @Date: 2018/6/13 19:48
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity exception(Exception e, HttpServletRequest req) {

        if (e instanceof ConstraintViolationException) {
            /**
             * 参数校验异常
             */
            Set<ConstraintViolation<?>> res = ((ConstraintViolationException) e).getConstraintViolations();
            StringBuilder sb = new StringBuilder("参数校验异常");
            Iterator<ConstraintViolation<?>> iterator = res.iterator();
            if (iterator.hasNext()) {
                sb.append(":\n");
                ConstraintViolation<?> constraintViolation = iterator.next();
                sb.append(constraintViolation.getMessage()).append("\n");
            }
            logger.error(sb.toString(), e);

            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        } else if (e instanceof MissingServletRequestParameterException) {
            /**
             * 缺少请求参数异常
             */
            StringBuilder sb = new StringBuilder("缺少请求参数异常");
            String parameterName = ((MissingServletRequestParameterException) e).getParameterName();
            sb.append("：缺少参数" + parameterName);
            logger.error(sb.toString(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }

        logger.error("全局异常", e);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
