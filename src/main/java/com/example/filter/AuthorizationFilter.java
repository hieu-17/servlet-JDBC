package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.example.model.NewModel;
import com.example.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletRequest response = (HttpServletRequest) servletResponse;
		String url = request.getRequestURI();
		if(url.startsWith("/admin")) {
			NewModel model =  (NewModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if (model!=null) {
				
			}else {
				response.
			}
		}else {
			filterChain.doFilter(servletRequest, servletResponse);// follow all acsses
		}
				
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
