package com.bing.base.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bing.base.vo.AjaxResult;
import com.bing.common.constants.Messages;
import com.bing.common.exception.CommonInformException;
import com.bing.common.exception.EpicLogicException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	final static Logger logger=LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
	@ExceptionHandler
	@ResponseBody
	 public AjaxResult defaultErrorHandler(HttpServletRequest req, Exception e)  {
		if(e instanceof CommonInformException){
			return AjaxResult.errorResult(e.getMessage());
		}else {
			logger.error(Messages.SYSTEM_EXCEPTION_MSG, e);
			if(e instanceof EpicLogicException ){
				return AjaxResult.errorResult(e.getMessage());
			}else{
				return AjaxResult.errorResult(Messages.SYSTEM_EXCEPTION_MSG);
			}
		}
	 }
}
