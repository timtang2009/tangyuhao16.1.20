package com.dooioo.samples.common;

import java.util.*;


public class Constants {

    static {
        DEFAULT_LOCALE = Locale.CHINA;
    }

    public static final int ESTATE_TYPE_ID = 1;
    public static final int PROPERTY_TYPE_ID = 2;

//	public static final String SESSION_USER = "SESSION_USER";
	public static final String SESSION_USER_V2 = "SESSION_USER_V2";
	
	public static final int WEB_PAGE_SIZE = 25;
	public static final int SMALL_PAGE_SIZE = 10;
	public static final int MAX_PAGE_SIZE = 50;
	public static final String SPLIT_SIGN = "^";
	public static final String PARAM_PREFIX = "pf_";
	public static final String PATTERN_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_TIMEZONE = "GMT+8";
	public static final Locale DEFAULT_LOCALE;
	public static final String DEFAULT_ENCODINIG = "UTF-8";
	public static final String DATABASE_CHARSET = "UTF-8";
	public static final int DEFAULT_SESSION_TIMEOUT = 600;

    public static final String SALE_ZH_KEY = "售";
    public static final String RENT_ZH_KEY = "租";


	public static final String DAO_INSERT = "insert";
	public static final String DAO_INSERTANDRETURNID = "insertAndReturnId";
	public static final String DAO_UPDATE = "update";
	public static final String DAO_DELETE = "delete";
	public static final String DAO_GETALL = "getAll";
	public static final String DAO_FINDBYID = "findById";
	public static final String DAO_QUERY_FOR_BEAN = "findByBean";
	public static final String DAO_QUERY_TOP_ONE = "queryTopOne";
	public static final String DAO_COUNT = "count";
	public static final String DAO_QUERY = "query";
	public static final String DAO_QUERY_FOR_PAGINATE = "queryForPaginate";
	public static final String DAO_SELECTMAP = "selectByMap";
	public static final String DAO_SELECTSQL = "selectBySql";

	public static final String DAO_POSTFIX_DELETE_PRIAMARYKEY = ".deleteByPrimaryKey";

    public static final String LAST_URL = "last_url";
    public static final String LOGIN_URL = "login_url";
    public static final String INDEX_URL = "index_url";

    public static final int MAX_PRICE = 1000000000; //
    public static final int MIN_FLOOR_LOW = -1000;

    public static final String PIC_M = "pic_m";
    public static final String PIC_S = "pic_s";
    public static final String PIC_L = "pic_l";
    public static final String PIC_ROOT = "pic_root";
    public static final String UPLOAD_PIC_ROOT = "upload_pic_root";
    public static final String UPLOAD_ORIG_PIC_ROOT = "upload_orig_pic_root";

    public static final String WZT_PIC_ROOT = "wzt_pic_root";

    public static final String PIC_NONE = "pic_none";
    public static final String GOOGLE_API_KEY = "google_api_key";
    public static final String PRODUCTION_IP = "production_ip";
    public static final String TEST_ENV = "test_env";
    public static final String ESTATE_URL = "estate_url";
    public static final String INQUIRY_URL = "inquiry_url";
    public static final String SEARCH_URL = "search_url";

    public static final String CASSANDRA_LISTEN = "cassandra_listen";
    public static final String CASSANDRA_PORT = "cassandra_port";

    public static final String VERSION = "version";

    public static final String NOSQL_IP = "nosql_ip";
    public static final String NOSQL_PORT = "nosql_port";
    public static final String NOSQL_DB = "nosql_db";
    public static final String NOSQL_CONNECTIONS = "nosql_connections";

    public static final String MAX_PRIVATE_COUNT = "maxPrivateCount";
    
    public static final String QUERY_LOCK_NUM = "queryLockNum"; 

    public static final String PROPERTY_AGENT = "住宅部经纪人";
    public static final String REGIONAL_MANAGER = "区域经理";
    public static final String BUSINESS_AGENT = "商用部经纪人";
    public static final String BUSINESS_MANAGER = "商用部分行经理";
    public static final String PROPERTY_MANAGER = "住宅部分行经理";

    public static final String PROPERTYPOSTER_URL = "propertyPosterUrl";
    public static final String INQUIRYPOSTER_URL = "inquiryPosterUrl";
    public static final String HASBILLINGURL = "hasBillingUrl";
    
    public static final String PROPERTY = "property";
    public static final String INQUIRY = "inquiry";
    
    public static final String FINESCORE = "fineScore";
    public static final String FINECATE = "fineCate";
    
    public static final int INVALIDE_NUMBER = -654321;
    
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    public static final String SEE_TEL_COUNT = "seeTelCount";
    
    public static final String	USER_OPER_PRE	= "userOperPre"; //用户行为操作URL前缀 登录-退出
    
    public static final int	USERCODEMASK = 997;
    public static final String COOKIEDOMAIN = "dooiooDomain";

    public static final String COOKIE_USER_ID = "userId";
    

    public static void main(String [] args) {
    }
}
