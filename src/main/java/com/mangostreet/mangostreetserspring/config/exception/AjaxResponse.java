package com.mangostreet.mangostreetserspring.config.exception;

//import lombok.Data;
//
//@Data
public class AjaxResponse {


    private boolean isok;
    private int code;
    private String message;
    private Object data;

    public boolean getIsok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }

//    2

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

//    3

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    //    4

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private AjaxResponse() {

    }

    //请求出现异常时的响应数据封装
//    public static AjaxResponse error(CustomException e) {
//
//        AjaxResponse resultBean = new AjaxResponse();
//        resultBean.setIsok(false);
//        resultBean.setCode(e.getCode());
//        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
//            resultBean.setMessage(e.getMessage());
//        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
//            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员电话：1375610xxxx进行处理!");
//        }else{
//            resultBean.setMessage("系统出现未知异常，请联系管理员电话：13756108xxx进行处理!");
//        }
//        return resultBean;
//    }

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }


}