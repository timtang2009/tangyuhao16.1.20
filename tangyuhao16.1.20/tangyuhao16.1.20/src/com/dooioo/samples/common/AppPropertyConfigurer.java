package com.dooioo.samples.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * 应用的配置文件
 * User: kqy
 * Date: 11-5-23 下午2:58
 */
public class AppPropertyConfigurer extends PropertyPlaceholderConfigurer {
    private static final Log log = LogFactory.getLog(AppPropertyConfigurer.class);

    @Override
    protected Properties mergeProperties() throws IOException {
        Properties superProps = super.mergeProperties();
        superProps.put("env", Configuration.getInstance().getEnv());
        log.info(">>>>> env:" + superProps.getProperty("env"));
        return superProps;
    }
}
