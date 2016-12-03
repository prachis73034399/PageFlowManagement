package com.bridgelabz.model;

public class pageAction 
{

private String sessionId;
	
	private String pageId;
	private String actionId ;
	private String pageName ;
	
	public String getSessionId() 
	{
		return sessionId;
	}
	public void setSessionId(String sessionId) 
	{
		this.sessionId = sessionId;
	}
	public String getPageId()
	{
		return pageId;
	}
	public void setPageId(String pageId) 
	{
		this.pageId = pageId;
	}
	public String getActionId() 
	{
		return actionId;
	}
	public void setActionId(String actionId) 
	{
		this.actionId = actionId;
	}
	public String getPageName() 
	{
		return pageName;
	}
	public void setPageName(String pageName) 
	{
		this.pageName = pageName;
	}

}
