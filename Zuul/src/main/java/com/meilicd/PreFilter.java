package com.meilicd;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
public class PreFilter extends ZuulFilter {
    /**
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取当前请求
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){//token为空 没有权限
            requestContext.setResponseStatusCode(405);
            requestContext.setResponseBody("not allowed!");
        }else{//token 不为空，有权限
            requestContext.setSendZuulResponse(true);//对该请求进行路由
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess",true);//让下一个Filter看到上一个Filter的状态
        }

        return null;
    }
}
