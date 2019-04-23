package com.zc.schoolinfo.model.enums;


/**
 * 
 * @ClassName: WebApiResultCodeEnum
 * @Description: WEB API接口异常
 * @Author: Jason
 * @CreateDate: 2018-03-24 12:28:15
 *
 */
public enum WebApiResultCodeEnum
{
	SUCCESS("000000", "SUCCESS", "成功"),
	USER_NOT_EXIST("000001", "USER_NOT_EXIST", "用户名不存在"),
	PASSWORD_ERROR("000002", "PASSWORD_ERROR", "密码错误"),
	USER_EXIST("000003", "USER_EXIST", "用户名已存在"),
	PARAM_IS_NULL("000022","PARAM_IS_NULL","参数不能为空"),
	NOT_LOGIN("000055","NOT_LOGIN","用户还未登录"),
	NOT_HAVE_PERMISSION("000403", "NOT_HAVE_PERMISSION", "没有相应权限访问"),
	UNKNOWN_ERROR("000056", "UNKNOWN_ERROR", "未知错误");


	private String code;
	private String msg;
	private String chineseMessage;


	WebApiResultCodeEnum(String code, String msg, String chineseMessage)
	{
		this.code = code;
		this.msg = msg;
		this.chineseMessage = chineseMessage;
	}

	public String getCode()
	{
		return code;
	}

	public String getMsg()
	{
		return msg;
	}


	/**
	 * 获取中文错误信息
	 *
	 * @return
	 */
	public String getChineseMessage()
	{
		return chineseMessage;
	}

	@Override
	public String toString() 
	{
		return "WebApiResultCodeEnum{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + ", chineseMessage='" + chineseMessage + '\'' + '}';
	}
}
