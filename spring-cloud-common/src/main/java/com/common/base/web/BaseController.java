package com.common.base.web;

import com.alibaba.fastjson.JSONObject;
import com.common.base.exception.BussinessException;
import com.common.util.StringUtils;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;


import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器支持类
 */
public abstract class BaseController {

    /**
     * 日志对象
     * <p>
     * 这里使用static final修饰Logger,表示所有的类都使用同一个Logger对象,实际这么做是很愚蠢的
     * 因为在打印的日志信息中看不出来是谁打印的日志信息
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    /**
     * 插入隐藏域模板
     */
    protected static final String TOKEN_INPUT = "<input type='hidden' name='%s' value='%s'/>";
    /**
     * JSON输出：结果标识
     */
    protected static final String RESULT_NAME = "result";
    /**
     * JSON输出：结果标识
     */
    protected static final String DATA_NAME = "data";
    /**
     * JSON输出：结果标识
     */
    protected static final String URL = "url";
    /**
     * 查询无数据，操作数据库无更新
     */
    protected static final int NO_RESULT = 0;
    /**
     * JSON输出：分页数据属性名称
     */
    protected static final String RESULT_PAGE = "page";
    /**
     * 跳转的tab切换按钮
     */
    protected static final String BUTTON = "button";
    /**
     * JSON输出：列表数据属性名称
     */
    protected static final String RESULT_LIST = "list";
    /**
     * JSON输出：提示信息
     */
    protected static final String MSG_NAME = "msg";
    protected static final String MSG_SUCCESS = "操作成功";
    protected static final String MSG_FAIL = "操作失败";

    private static final String ERROR_400 = "error/400";
    private static final String ERROR_403 = "error/403";

    public static final String RESPONSE_TYPE_JSON = "application/json";


    /**
     * 回调打印，用于响应UFX
     */
    protected void printSuccessReturn(final HttpServletResponse response) {
        try {
            response.reset();
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write("操作成功");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 回调打印，用于响应UFX
     */
    protected void printSuccessReturn(final HttpServletResponse response, Object map) {
        try {
            response.reset();
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.write(reBuildJson(map));
            out.flush();
            out.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 参数绑定异常
     *
     * @return
     */
    @ExceptionHandler({BindException.class, ConstraintViolationException.class, ValidationException.class})
    public String bindException() {
        return ERROR_400;
    }

    /**
     * 授权登录异常
     *
     * @return
     */
    @ExceptionHandler({AuthenticationException.class})
    public String authenticationException() {
        return ERROR_403;
    }

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BussinessException.class)
    //@ResponseBody
    public void handleBussinessException(BussinessException e) throws BussinessException {
//		Map<String, Object> map = new HashMap();
//		map.put(RESULT_NAME, false);
//		map.put(MSG_NAME, e.getMessage());
//		return map;
        throw new BussinessException(e.getMessage());
    }

    /**
     * 处理结果返回集
     *
     * @param result
     * @param msg
     * @param url
     * @return
     */
    protected Map<String, Object> renderResult(boolean result, String msg, String url) {
        Map<String, Object> rs = Maps.newHashMap();
        rs.put(RESULT_NAME, result);
        rs.put(MSG_NAME, msg);
        rs.put(URL, url);
        return rs;
    }

    protected Map<String, Object> renderResult(boolean result, String msg, String url, String button) {
        Map<String, Object> rs = Maps.newHashMap();
        rs.put(RESULT_NAME, result);
        rs.put(MSG_NAME, msg);
        rs.put(URL, url);
        rs.put(BUTTON, button);
        return rs;
    }


    /**
     * 处理结果
     *
     * @param result 是否成功
     * @param msg    消息
     */
    protected Map<String, Object> renderResult(final boolean result, final String msg) {
        final Map<String, Object> rtn = Maps.newHashMap();
        rtn.put(RESULT_NAME, result);
        rtn.put(MSG_NAME, msg);
        return rtn;
    }

    /**
     * 处理结果
     */
    protected Map<String, Object> renderSuccessResult() {
        final Map<String, Object> rtn = Maps.newHashMap();
        rtn.put(RESULT_NAME, true);
        rtn.put(MSG_NAME, MSG_SUCCESS);
        return rtn;
    }

    /**
     * 渲染结果，返回数据
     *
     * @param data 返回数据
     */
    protected Map<String, Object> renderSuccessResultWithData(Object data) {
        final Map<String, Object> rtn = Maps.newHashMap();
        rtn.put(RESULT_NAME, true);
        rtn.put(MSG_NAME, MSG_SUCCESS);
        rtn.put(DATA_NAME, data);
        return rtn;
    }

    /**
     * 取得认证信息
     *
     * @return
     */
//    protected Object getPrincipal() {
//        final PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
//        if (principals == null) {
//            return null;
//        }
//        return principals.getPrimaryPrincipal();
//    }

    /**
     * 取得错误信息
     *
     * @param bindingResult
     * @return
     */
    @SuppressWarnings("Duplicates")
    public String getBindErrors(final BindingResult bindingResult) {
        final StringBuilder errorStr = new StringBuilder();
        final List<ObjectError> errors = bindingResult.getAllErrors();
        final int errorLen = errors.size() - 1;
        for (int i = errorLen; i >= 0; i--) {
            errorStr.append(errors.get(i).getDefaultMessage()).append("<br>");
        }
        return errorStr.substring(0, errorStr.length() - 4);
    }

    /**
     * 校验出现错误，返回错误信息
     *
     * @param bindingResult
     * @return
     */
    public Map<String, Object> renderBindingResult(final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return renderResult(false, getBindErrors(bindingResult));
        }
        return null;
    }

  

    /**
     * 回调参数拼接共用方法
     *
     * @return
     */
    public String getRequestParams(final HttpServletRequest request) {
        StringBuilder params = new StringBuilder();
        try {
            @SuppressWarnings("rawtypes") final Enumeration e = request.getParameterNames();
            while (e.hasMoreElements()) {
                String parName = (String) e.nextElement();
                String value = request.getParameter(parName);
                params.append(parName).append("=").append(value).append("&");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return params.toString();
    }

    /**
     * 回调参数拼接共用方法  渤海银行
     *
     * @return
     */
    public Map<String, String> getRequestMap(final HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            @SuppressWarnings("rawtypes") final Enumeration e = request.getParameterNames();
            while (e.hasMoreElements()) {
                String parName = (String) e.nextElement();
                String value = request.getParameter(parName);
                map.put(parName, value);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return map;
    }


    /**
     * 过滤参数json串中的空值，避免数据库存储太多无用数据
     *
     * @param object
     * @return
     */
    protected String reBuildJson(Object object) {
        String jsonStr = JSONObject.toJSONString(object);
        return StringUtils.reBuildJson(jsonStr);
    }

  
}
