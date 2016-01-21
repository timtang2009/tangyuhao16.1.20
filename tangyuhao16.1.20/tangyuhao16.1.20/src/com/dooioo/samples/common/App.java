package com.dooioo.samples.common;

import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 13-3-1
 * Time: 下午5:34
 */
public class App {

    private static RestTemplate client=getRestTemplate();

    private static int DEFAULT_PORT = 8080;

    private static String DEFAULT_HOST = "localhost";

    private static int port=DEFAULT_PORT;

    private static String hostName = DEFAULT_HOST;


    public static  void main(String[] args) throws IOException {
        try {
            testHappyDayWithForm();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void testHappyDayWithForm() throws Exception {

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.add("grant_type", "password");
        formData.add("client_id", "my-trusted-client");
        formData.add("scope", "read");
        formData.add("username", "marissa");
        formData.add("password", "koala");

        ResponseEntity<String> response = postForString("/sparklr2/oauth/token", formData);
        System.out.println( response.getStatusCode());
        System.out.println(response.getHeaders().getFirst("Cache-Control"));

//        DefaultOAuth2SerializationService serializationService = new DefaultOAuth2SerializationService();
//        OAuth2AccessToken accessToken = serializationService.deserializeJsonAccessToken(new ByteArrayInputStream(
//                response.getBody().getBytes()));

        // now try and use the token to access a protected resource.

        // first make sure the resource is actually protected.
        //assertNotSame(HttpStatus.OK, serverRunning.getStatusCode("/sparklr/photos?format=json"));

        // now make sure an authorized request is valid.
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", String.format("%s %s", OAuth2AccessToken.BEARER_TYPE, accessToken.getValue()));
        //assertEquals(HttpStatus.OK, serverRunning.getStatusCode("/sparklr/photos?format=json", headers));
    }

    public static ResponseEntity<String> postForString(String path, MultiValueMap<String, String> formData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
        System.out.println(getUrl(path));
        return client.exchange(getUrl(path), HttpMethod.POST, new HttpEntity<MultiValueMap<String, String>>(formData,
                headers), String.class);
    }
    public static String getUrl(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "http://" + hostName + ":" + port + path;
    }

    public static RestTemplate getRestTemplate() {
        RestTemplate client = new RestTemplate();
        CommonsClientHttpRequestFactory requestFactory = new CommonsClientHttpRequestFactory() {
            @Override
            protected void postProcessCommonsHttpMethod(HttpMethodBase httpMethod) {
                httpMethod.setFollowRedirects(false);
                // We don't want stateful conversations for this test
                httpMethod.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
            }
        };
        client.setRequestFactory(requestFactory);
        client.setErrorHandler(new ResponseErrorHandler() {
            // Pass errors through in response entity for status code analysis
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            public void handleError(ClientHttpResponse response) throws IOException {
            }
        });
        return client;
    }
}
