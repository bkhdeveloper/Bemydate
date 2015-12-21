package com.example.webservice;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.SystemClock;

import com.example.hamdisoap.Act_Account.GENDER;

public class SoapManager {

	private static final String NAMESPACE = "http://v2.webservices.main.connector.bemy.datedicted.de/";
	private static final String URL = "http://www.bemydate.mobi/connector/v2/orderflow?wsdl";

	private static final String METHOD_NAME_isNikNameExist = "isNicknameAvailable";
	private static final String METHOD_NAME_registerUser = "registerUser";

	public boolean isNikNameAvailable(String pNikName){

		boolean lIsExist=false;
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME_isNikNameExist);           

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		PropertyInfo p = new PropertyInfo();
		p.setName("nickname");
		p.setValue(pNikName);
		p.setType(String.class);
		request.addProperty(p);

		envelope.setOutputSoapObject(request);

		HttpTransportSE ht = new HttpTransportSE(URL);
		try {

			String SOAP_ACTION=NAMESPACE+METHOD_NAME_isNikNameExist;
			ht.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive)envelope.getResponse();

			lIsExist=Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lIsExist;
	}


	public float registerUser(String pNikName,String pEmail,String pPassWord, GENDER pGender){

		
		float lReturn=-1;
		
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME_registerUser);           

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		//--- fix : TEST
		PropertyInfo p1 = new PropertyInfo();
		p1.setName("orderFlowName");
		p1.setValue("TEST");
		p1.setType(String.class);
		request.addProperty(p1);

		//--- session ID
		PropertyInfo p2 = new PropertyInfo();
		p2.setName("sessionId");
		p2.setValue(""+SystemClock.currentThreadTimeMillis());
		p2.setType(String.class);
		request.addProperty(p2);

		//--- fixe: test-bemy-unixtimestamp@android.com
		PropertyInfo p3 = new PropertyInfo();
		p3.setName("email");
		p3.setValue(pEmail);
		p3.setType(String.class);
		request.addProperty(p3);

		//---
		PropertyInfo p4 = new PropertyInfo();
		p4.setName("nickname");
		p4.setValue(pNikName);
		p4.setType(String.class);
		request.addProperty(p4);

		//---
		PropertyInfo p5 = new PropertyInfo();
		p5.setName("password");
		p5.setValue(pPassWord);
		p5.setType(String.class);
		request.addProperty(p5);

		//---
		PropertyInfo p6 = new PropertyInfo();
		p6.setName("gender");
		p6.setValue(pGender.name());
		p6.setType(String.class);
		request.addProperty(p6);

		//--- static
		PropertyInfo p7 = new PropertyInfo();
		p7.setName("birthdate");
		p7.setValue("1980-02-20");
		p7.setType(String.class);
		request.addProperty(p7);

		//---fixe
		PropertyInfo p9 = new PropertyInfo();
		p9.setName("locale");
		p9.setValue("fr_LU");
		p9.setType(String.class);
		request.addProperty(p9);

		//--- fixe sur tn
		PropertyInfo p10 = new PropertyInfo();
		p10.setName("countryCode");
		p10.setValue("at");
		p10.setType(String.class);
		request.addProperty(p10);

		//---souuse
		PropertyInfo p11 = new PropertyInfo();
		p11.setName("location");
		p11.setValue("Wien");
		p1.setType(String.class);
		request.addProperty(p11);

		//---
		PropertyInfo p12 = new PropertyInfo();
		p12.setName("facebookId");
		p12.setValue("hamdibkh");
		p12.setType(String.class);
		request.addProperty(p12);
		
		PropertyInfo p13 = new PropertyInfo();
		p13.setName("msisdn");
		p13.setValue("");
		p13.setType(String.class);
		request.addProperty(p13);
		
		PropertyInfo p14 = new PropertyInfo();
		p14.setName("webServicePassword");
		p14.setValue("87UZIUZjhk");
		p14.setType(String.class);
		request.addProperty(p14);

		envelope.setOutputSoapObject(request);

		HttpTransportSE ht = new HttpTransportSE(URL);
		try {

			String SOAP_ACTION=NAMESPACE+METHOD_NAME_registerUser;
			ht.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
			

			lReturn=Float.parseFloat(response.toString());

		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lReturn;
	}


}
