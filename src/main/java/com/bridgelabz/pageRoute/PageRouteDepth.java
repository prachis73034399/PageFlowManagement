package com.bridgelabz.pageRoute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.bridgelabz.model.PageDepth;



public class PageRouteDepth 
{

	public HashMap<String, Integer> pageDepthIdCount(HashMap<String, List<String>> sessionHashMap)
	{
		// creating object of HashMap for storing DEpthId: Page
		HashMap<String, Integer> depthIdWithPageDepthCount = new HashMap<String, Integer>();
		// keySet method of HashMap for getting set of sessionIds and storing it in a Set collection type
		Set<String> setOfSessionId = sessionHashMap.keySet();
		String pageRoute;
		
		// for loop for retrieving each HashMap sessionId
		for (String sessionId : setOfSessionId)
		{
			// we are avoiding column headers of session Id and PageId
			if("session_id".equalsIgnoreCase(sessionId) )
			{
				continue;
			}
			
			List<String> pageIdList  = sessionHashMap.get(sessionId);

			if( pageIdList.size() == 0 )
			{
				continue;
			}
			
			// if condition satisfies when list is having more than one element
			if (pageIdList.size() > 1) 
			{
				// for loop for creating pageRoute
				for (int i = 0; i < pageIdList.size() - 1; i++)
				{
					String firstPage = pageIdList.get(i);
					String secondPage = pageIdList.get(i + 1);
					// string concatenating
					pageRoute =  (i+1)+ ":" + firstPage + ":" + secondPage;
					Integer c = depthIdWithPageDepthCount.get(pageRoute);
					if(c == null)
					{
						c = 0;
					}
					c++;
					depthIdWithPageDepthCount.put(pageRoute, c);
				}
				System.out.println( depthIdWithPageDepthCount);
			}
			else
			{
				// string concatenating
				pageRoute =  0+ ":" + pageIdList.get(0) + ":" + 0;
				Integer c = depthIdWithPageDepthCount.get(pageRoute);
				if(c == null)
				{
					c = 0;
				}
				
				c++;
				depthIdWithPageDepthCount.put(pageRoute, c);
			}

		}
		return depthIdWithPageDepthCount;
	}
	
	
	}