/**
 * DMA - 
 * Copyright © 2013 DMA. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF DMA. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF DMA.
 */
package com.dma.exception;


/**
 * The <code>UserAlreadyExistException</code> is a exception class that should be used if User is already exist in ETMS system 
 * @author seasia
 * @timestamp Jul 18, 2013 4:19:38 PM
 *  
 */
public class UserAlreadyExistException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public UserAlreadyExistException(String message) {
		super(message);
	}
	

}
