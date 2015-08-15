package org.addisonlee.component;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.module.http.internal.ParameterMap;

public class PrepareDoExpressCheckoutPayment implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		java.util.HashMap queryParams = (java.util.HashMap) eventContext.getMessage()
				.getInboundProperty("http.query.params");

		map.put("token", queryParams.get("token"));
		map.put("PayerID", queryParams.get("PayerID"));
		
		return map;
	}

}
