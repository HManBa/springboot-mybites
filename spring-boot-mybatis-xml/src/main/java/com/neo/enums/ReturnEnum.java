package com.neo.enums;

/*************************
* @ClassName: ReturnEnum
* @Description: 返回编码
* @author: huhao
* @date 2019年12月23日 上午10:12:41
*
**************************/
public enum ReturnEnum {
	
    OK(200, "操作成功"),
    INVALID_REQUEST(400, "参数错误"),
    UNAUTHORIZED(401, "没有权限"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    NOT_ACCEPTABLE(406, "请求的格式不正确"),
    GONE(410, "数据被删除"),
    UNPROCESABLE_ENTITY(422, "参数验证错误"),
    INTERNAL_SERVER_ERROR(500, "服务器发生错误"),
    UN_KNOW_ERROR(500, "未知错误"),
    FAIL(501, "操作失败"),

    MODEL_NOT_EXIST(1000, "模型不存在"),

    USERNAME_OR_PASSWORD_ERR(2000, "用户名或密码错误"),
    DELETE_DEFAULT_PHOTO_ERR(2001, "默认头像不可删除"),
    SESSION_INVALID_ERR(2002, "登录会话失效"), TOKEN_ERR(200, "token无效"),

    QUOTE(3000, "数据被引用，不可删除"),
    EXIST(3001, "数据已存在，不可创建");

    private final int code;
    private final String message;
    
    ReturnEnum(final int code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

}
