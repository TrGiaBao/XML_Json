package xmldemojson;

import org.json.simple.JSONObject;

public class Jsondemo {
	public static void main(String[] args) {
		JSONObject jo = new JSONObject();
		
		jo.put("username", "tgbao");
		jo.put("password", "123456");
		System.out.println(jo);
		System.out.println(jo.get("username"));
	}
}
