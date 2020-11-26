package org.bbva.kidsbankingapp.utils;
 
import java.io.Serializable;
 
public class ServiceException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
 
    public ServiceException() {
        super();
    }
    public ServiceException(String msg)   {
        super(msg);
    }
    public ServiceException(String msg, Exception e)  {
        super(msg, e);
    }
}