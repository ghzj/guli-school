package io.renren.Interceptor;

import io.renren.dao.GeneratorDao;
import io.renren.entity.context.ErrorCodeContext;
import io.renren.entity.context.ErrorCodeContextHolder;
import io.renren.utils.GenUtils;
import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
public class ErrorCodeInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Qualifier("getGeneratorDao")
    @Autowired
    private GeneratorDao generatorDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if("/sys/generator/code".equals(request.getRequestURI()) ){
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
            Configuration config = GenUtils.getConfig();
            int code = config.getInt("errorCode");
//            int code = 1000000;
            List<Map<String, Object>> list = generatorDao.queryList(null);
            for (Map<String, Object> table : list) {
                String tableName = (String)table.get("tableName");
                map.put(tableName,code++ * 1000);
            }
            ErrorCodeContextHolder.setContext(new ErrorCodeContext().setErrorCode(map));
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if("/sys/generator/code".equals(request.getRequestURI()) ){
            ErrorCodeContextHolder.clear();
        }
        super.afterCompletion(request, response, handler, ex);
    }
}
