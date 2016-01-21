package com.dooioo.samples.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ImportResource;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: kqy
 * Date: 2011-4-20 14:35:31
 */
public class Configuration {
    private static final Logger log = Logger.getLogger(Configuration.class);
    private PropertiesConfiguration propConfig;
    private static Configuration configuration;

    private String pic_s;
    private String pic_m;
    private String pic_l;
    private String indexUrl;
    private String picRoot;
    private String uploadPicRoot;
    private String uploadOrigPicRoot;
    private String loginUrl;
    private String estateUrl;
    private String inquiryUrl;//客源
    private String searchUrl;
    private String env;
    private String googleApiKey;
    private String version;
    private int seeTelCount;
    private String userOperPre;
    private String dooiooDomain;
    
    private Configuration() {
        env = evn();
        propConfig = new PropertiesConfiguration();
        propConfig.setEncoding("utf-8");
        try {
            propConfig.load(env + "_portal.properties");
        } catch (ConfigurationException e) {
            log.error("load portal.properties error !");
            return;
        }

        picRoot = propConfig.getString(Constants.PIC_ROOT);
        uploadPicRoot = propConfig.getString(Constants.UPLOAD_PIC_ROOT);
        uploadOrigPicRoot = propConfig.getString(Constants.UPLOAD_ORIG_PIC_ROOT);
        loginUrl = propConfig.getString(Constants.LOGIN_URL, "http://192.168.0.100:8000");
        indexUrl = propConfig.getString(Constants.INDEX_URL, "/house/list");

        pic_s = propConfig.getString(Constants.PIC_S, "100x100");
        pic_m = propConfig.getString(Constants.PIC_M, "200x150");
        pic_l = propConfig.getString(Constants.PIC_L, "500x350");

        estateUrl = propConfig.getString(Constants.ESTATE_URL, "");
        inquiryUrl = propConfig.getString(Constants.INQUIRY_URL, "");
        searchUrl = propConfig.getString(Constants.SEARCH_URL, "");

        googleApiKey = propConfig.getString(Constants.GOOGLE_API_KEY, "");
        version = propConfig.getString(Constants.VERSION, "1.0");
        seeTelCount = propConfig.getInt(Constants.SEE_TEL_COUNT, 0);
        userOperPre = propConfig.getString(Constants.USER_OPER_PRE, "");
        
        dooiooDomain = propConfig.getString(Constants.COOKIEDOMAIN, ".dooioo.net");
//        housePrefix = propConfig.getString(Constants.HOUSE_PREFIX,  "http://192.168.0.133:8090");
//        officePrefix = propConfig.getString(Constants.OFFICE_PREFIX,  "http://192.168.0.133:9090");
//        officeOrgLongCode = propConfig.getString(Constants.OFFICE_ORG_LONGCODE, "12020001/12030351");
    }

    public synchronized static Configuration getInstance() {
        if(configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    public PropertiesConfiguration getPropConf() {
        return propConfig;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public String getPicRoot() {
        return picRoot;
    }

    public String getUploadPicRoot() {
        return uploadPicRoot;
    }

    public String getUploadOrigPicRoot() {
        return uploadOrigPicRoot;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getPic_s() {
        return pic_s;
    }

    public String getPic_m() {
        return pic_m;
    }

    public String getPic_l() {
        return pic_l;
    }

    public String getEnv() {
        return env;
    }

    public String getGoogleApiKey() {
        return googleApiKey;
    }

    public String getEstateUrl() {
        return estateUrl;
    }
    
    public String getInquiryUrl() {
        return inquiryUrl;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public String getVersion() {
        return version;
    }

    public int getSeeTelCount() {
        return seeTelCount;
    }

	public String getUserOperPre() {
		return userOperPre;
	}

	public String getDooiooDomain() {
		return dooiooDomain;
	}

	private String evn() {
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "development";
        }
        GlobalConfiguration globalConfiguration = new GlobalConfiguration();
        Set<String> productionIpSet = globalConfiguration.getProductionIp();
        String testEnv = globalConfiguration.getTestEnv();
        	
        if(StringUtils.isEmpty(testEnv)) {
            if(productionIpSet.contains(ip.getHostAddress()))
                return "production";
        } else {
            return testEnv;
        }
        
        return "development";
    }
    
    

    @Configurable
    @ImportResource(value = "/spring/applicationContext.xml")
    private class GlobalConfiguration {
        private PropertiesConfiguration prop;
        private String productionIp;
        private String testEnv;
        private String appName;

        public GlobalConfiguration() {
            prop = new PropertiesConfiguration();
            prop.setEncoding("utf-8");
            try {
                prop.load("global.properties");
            } catch (ConfigurationException e) {
                log.error("load global.properties error !");
                return;
            }
            productionIp = prop.getString(Constants.PRODUCTION_IP, "");
            testEnv = prop.getString(Constants.TEST_ENV, "");
//            appName = prop.getString(Constants.APP_NAME,"house");
        }

        public Set<String> getProductionIp() {
            Set<String> set = new HashSet<String>();
            if(StringUtils.isEmpty(productionIp))
                return set;

            for (String str : productionIp.split("\\|\\|")) {
                set.add(str.trim());
            }
            return set;
        }

        public String getTestEnv() {
            return testEnv;
        }

		public String getAppName() {
			return appName;
		}
    }
    
}
