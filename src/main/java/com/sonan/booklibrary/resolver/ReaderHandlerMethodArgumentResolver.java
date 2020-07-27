package com.sonan.booklibrary.resolver;

import com.sonan.booklibrary.model.Reader;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Jaeseong on 2020/07/27
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class ReaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Reader.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Authentication auth = (Authentication) nativeWebRequest.getUserPrincipal();
        return auth != null && auth.getPrincipal() instanceof  Reader ? auth.getPrincipal() : null;
    }
}
