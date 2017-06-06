/**
 * DMA - Data Management System. 
 * Copyright © 2013 DMA. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF DMA. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF DMA.
 */
package com.dma.email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <code>MailTemplateFactory</code> is used to get the Email Templates from the HTML pages located in resources folder
 * @author rsingh4
 * @timestamp Jul 18, 2013
 */
public class MailTemplateFactory {

    private static final String TEMPLATE_PATH = "resources/";

    /**
     * Get Forgot Password Email Format in StringBuffer
     * @param firstName
     * @param link
     * @return
     */
    public static StringBuffer getForgotPasswordEmailFormat(String firstName,String link) {
        String s = htmlTemplateToStringBuffer("forgot-password.html").toString().replaceAll("##FIRSTNAME##", firstName).replaceAll("##LINK##", link);
        return new StringBuffer(s);
    }
    
    /**
     * Get Welcome Message Email Format in StringBuffer
     * @param firstName
     * @param username
     * @param loginUrl
     * @param forgotPasswordUrl
     * @return
     */
    public static StringBuffer getWelcomeMessageEmailFormat(String firstName,String username,String loginUrl,String forgotPasswordUrl) {
        String s = htmlTemplateToStringBuffer("welcome-message.html").toString().replaceAll("##FIRSTNAME##", firstName).replaceAll("##USERNAME##", username).replaceAll("##LOGINURL##", loginUrl).replaceAll("##FORGOTURL##", forgotPasswordUrl);
        return new StringBuffer(s);
    }
    
    /**
     * Get HTML content in StringBuffer
     * @param templateName
     * @return
     */
    private static StringBuffer htmlTemplateToStringBuffer(String templateName) {

        StringBuffer sb = new StringBuffer();
        InputStream stream = MailTemplateFactory.class.getResourceAsStream(TEMPLATE_PATH + templateName);
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        try {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb;

    }
    
  
}
