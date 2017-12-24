package com.jabin.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangbbj on 2017/8/24.
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    protected ModelMap modelMap;

    public BaseController() {
        if (modelMap == null) {
            modelMap = new ModelMap();
        }
    }
}