package com.zc.schoolinfo.common;



import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WebApiResult
 * @Description: 接口返回值
 * @Author: shangkun.jin
 * @CreateDate: 2018-03-20 17:28:15
 */
public class WebApiResult implements Serializable {

    private static final long serialVersionUID = -236053672816307102L;

    /**
     * 返回code
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static WebApiResult build(String code, String msg) {
        WebApiResult apiResult = new WebApiResult();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        return apiResult;
    }

    public static WebApiResult buildError(String code, String msg, Object data) {
        WebApiResult apiResult = new WebApiResult();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        apiResult.setData(data);
        return apiResult;
    }

    public static WebApiResult build(WebApiResultCodeEnum resultCodeEnum) {
        WebApiResult apiResult = new WebApiResult();
        apiResult.setCode(resultCodeEnum.getCode());
        apiResult.setMessage(resultCodeEnum.getChineseMessage());
        return apiResult;
    }

    public static WebApiResult buildSuccess(Object data) {
        WebApiResult apiResult = new WebApiResult();
        apiResult.setCode(WebApiResultCodeEnum.SUCCESS.getCode());
        apiResult.setMessage(WebApiResultCodeEnum.SUCCESS.getChineseMessage());

        if (data instanceof Page) {
            Page pageData = (Page)data;
            Map<String, Object> result = new HashMap<>();
            result.put("pages",pageData.getPages());
            result.put("total",pageData.getTotal());
            result.put("pageList", pageData.getResult());
            apiResult.setData(result);
        } else {
            apiResult.setData(data);
        }
        return apiResult;
    }

    public WebApiResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public WebApiResult() {

    }

    @Override
    public String toString() {
        return "ApiResult{" + "code='" + code + '\'' + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
