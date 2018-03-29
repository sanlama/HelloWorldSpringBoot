package com.sansoft.errorController;

import com.sansoft.EoorHamdling.ErrorHamdlingModel;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by SanLama on 3/29/2018.
 */
@Controller
@ControllerAdvice
public class CustomErrorController implements ErrorViewResolver {


    @Override
    public ModelAndView resolveErrorView(javax.servlet.http.HttpServletRequest httpServletRequest, HttpStatus httpStatus, Map<String, Object> map) {

        ModelAndView model=new ModelAndView();
        model.setViewName("errorpage");
        model.addObject("code",map.get("status"));
        model.addObject("message",map.get("path"));
        model.addObject("errors",map.get("error"));
        return model;
    }
}
