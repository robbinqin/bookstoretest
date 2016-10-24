package com.lce.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class SetAllCharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		try {
			request=(HttpServletRequest) req;
			response=(HttpServletResponse) resp;
		} catch (Exception e) {
			throw new RuntimeException("no-http request or response");
		}
		//获取用户配置的参数
		String encoding=filterConfig.getInitParameter("encoding");
		if(encoding==null)
			encoding="UTF-8";//默认编码		
		//设置响应输出流编码
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		//POST请求参数编码
		request.setCharacterEncoding(encoding);
		//GET请求参数编码
		GetHttpServletRequest getRequest=new GetHttpServletRequest(request);
		chain.doFilter(getRequest, response);
		//设置 filter in web.xml
	}	

	@Override
	public void destroy() {

	}

}
class GetHttpServletRequest extends HttpServletRequestWrapper {

	public GetHttpServletRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value=super.getParameter(name);
		if(value==null)
			return value;
		//获取请求方式
		String method=super.getMethod();
		if("get".equalsIgnoreCase(method)){
			try {
				value=new String(value.getBytes("ISO-8859-1"), super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		return value;
	}	
}

