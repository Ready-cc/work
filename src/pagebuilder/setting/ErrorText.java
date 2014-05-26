package pagebuilder.setting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  final  class ErrorText{
	Map<String,String> addresstips = new HashMap<String,String>();
	public void nulltips() {
		addresstips.put("nname", "请填写收货人");
		addresstips.put("nprovin", "请填写所在省/直辖市");
		addresstips.put("ncity", "请请填写所在市/区/县");
		addresstips.put("ndetail", "请填写详细地址");
		addresstips.put("ncode", "邮编输入有误");
		addresstips.put("nphone", "请输入联系电话");
		
	}
	public void lenthtips() {
		// TODO Auto-generated method stub
		addresstips.put("lname", "长度应保持在2个到20个字符之间");
	}
	public String falsetps(String key) {
		// TODO Auto-generated method stub
		addresstips.put("fname", "请输入正确的收货人姓名");
		addresstips.put("fprovin", "没有匹配到正确的省/直辖市，请重新输入");
		addresstips.put("fcode", "邮编输入有误");
		addresstips.put("fphone", "联系电话输入有误");
		return addresstips.get(key);
	}
	
}
