package session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtility {
	
	
	public boolean checkForSession(HttpServletRequest request)
	{
		
		HttpSession session=request.getSession(false);
		System.out.println("+++++++++++++>>>>>>> in checkfor session"+session);

		if(session==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		 
	}

}
