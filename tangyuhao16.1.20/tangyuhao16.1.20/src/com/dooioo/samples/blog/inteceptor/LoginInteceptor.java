package com.dooioo.samples.blog.inteceptor;

import com.dooioo.samples.blog.service.UserService;
import com.dooioo.samples.common.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 * 鐧诲綍鎷︽埅鍣� User: kqy Date: 11-3-21 Time: 涓嬪崍5:17
 */
public class LoginInteceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;

	public boolean preHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession(false);

        if (session != null && session.getAttribute(Constants.SESSION_USER_V2) != null) {
            return true;
        }

		httpServletResponse.sendRedirect("http://localhost:8090/user/login?ref=" + URLEncoder.encode(getFullUrl(httpServletRequest), "utf-8"));
		return false;
	}

	public void postHandle(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
			throws Exception {
	}

	public void afterCompletion(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	}

	private String getFullUrl(HttpServletRequest httpServletRequest) {
		String url = httpServletRequest.getRequestURL().toString();
		if (!StringUtils.isEmpty(httpServletRequest.getQueryString())) {
			url += "?" + httpServletRequest.getQueryString();
		}
		return url;
	}
}
