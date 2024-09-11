package com.pj224.app.member;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsApi {
	public static void main(String[] args) {
		String api_key = "NCSLEUNHSPWZXIGP";
		String api_secret = "GAVYDCIOB4XVL3FHXX7XIWGISDJ894RC";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", "발신번호");
		params.put("from", "수신번호"); // 무조건 자기번호 (인증)
		params.put("type", "SMS");
		params.put("text", "보낼 메시지를 입력하시오");
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			// send() 는 메시지를 보내는 함수
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}

}
