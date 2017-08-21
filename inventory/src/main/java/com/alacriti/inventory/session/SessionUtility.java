package com.alacriti.inventory.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SessionUtility {
	
	public static final Logger log= Logger.getLogger(SessionUtility.class);

	
	public boolean checkForSession(HttpServletRequest request)
	{
		
		HttpSession session=request.getSession(false);

		if(session==null)
		{
			log.debug("No Session..");
			return false;
		}
		else
		{
			log.debug("Session Exist..");
			return true;
		}
		 
	}

}
