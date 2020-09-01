package com.oracle.gdms.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.GoodsType;
import com.oracle.gdms.entity.ResponseEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.service.impl.GoodsServiceImpl;
import com.oracle.gdms.util.Factory;

@Path("/hongyan")
public class Hongyan {
	
	@Path("/sing")
	@GET
	public String sing() {
		System.out.print("�����������");
		return "hello";
	}

	@Path("/sing/{name}")
	@GET
	public String sing(@PathParam("name") String name) {  //name����·��name
		System.out.println("����="+name);
		
		return "ok";
	}
	@Path("/sing/ci")   ////http://localhost:8080/gdms-web/rest/hongyan/sing/ci��name=
	public String singOne(@QueryParam("name") String name) {  //name����·��name
		System.out.println("���="+name);
		
		return "���";
	}
	
	@Path("/push/one")
	@POST
	public String push(@FormParam("name") String name,@FormParam("sex") String sex) {  //name����·��name
		System.out.println("��Ʒ����="+name);
		
		return "from";
	}
	
	@Path("/push/json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String push(String jsonparam) {  //jsonparam ���Դ����
		System.out.println(jsonparam);
		JSONObject j = JSONObject.parseObject(jsonparam);
		String name = j.getString("name");
		String sex = j.getString("sex");
		String age = j.getString("age");
		
		System.out.println("name=" +name);
		System.out.println("sex="+sex);
		System.out.println("age="+age);

		return "from";
    }
	
//	@Path("/goods/update/type")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)   //�涨���صĽ��Ϊjson����
//	
//	public String updateGoodsType(String jsonparam) {
//		JSONObject j = JSONObject.parseObject(jsonparam);
//		String goodsid = j.getString("goodsid");
//		String gtid = j.getString("gtid");
//		System.out.println("Ҫ�޸ĵ���Ʒid="+goodsid+"Ҫ�޸ĵ���Ʒ����id"+gtid);
//		
//		GoodsService service = ;
//		return "update success";
//	}
	

	@Path("/goods/update/type")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	// �涨���صĽ��Ϊjson����
	public String updateGoodsType(String jsonparam) {
		
		System.out.println("str=" + jsonparam);
		JSONObject j = JSONObject.parseObject(jsonparam);
		String goodsid = j.getString("goodsid");
		String gtid = j.getString("gtid");
	//	System.out.println("Ҫ�޸ĵ���Ʒid=" + goodsid + "   Ŀ�����id=" + gtid);
		GoodsEntity goods = new GoodsEntity();
		goods.setGoodsid(Integer.parseInt(goodsid));
		goods.setGtid(Integer.parseInt(gtid));
		GoodsService service = (GoodsService) Factory.getInstance().getObject("goods.service.impl");
		int count = service.updateType(goods);
		return j.toJSONString();
		
	}
	
//	@Path("/goods/bytype")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<GoodsModel>pushGoodsByType(GoodsType type){
//		List<GoodsModel>list = null;
//		
//		GoodsService service = (GoodsService) Factory.getInstance().getObject("goods.service.impl");
//		System.out.print("");
//		return list;
//		
//	}
//	
	@Path("/goods/push/bytype")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<GoodsModel> findByType(GoodsType type){
		List<GoodsModel>list = null;
		GoodsService s = (GoodsService) Factory.getInstance().getObject("goods.service.impl");
		list = s.findByType(type.getGtid());
		System.out.println("size="+list.size());
		
		return list;
	}
	
	@Path("/goods/push/one")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity pushGoodsOne(String jsonparam) {
		//{goods:{goodsid:42,name:��Ȫˮ��price��3.5}}
		ResponseEntity r = new ResponseEntity();
		

		try {
			JSONObject j =JSONObject.parseObject(jsonparam);
			String gs = j.getString("goods");
			GoodsModel goods = JSONObject.parseObject(gs,GoodsModel.class);
			System.out.println("������յ�");
			System.out.println("��Ʒid="+goods.getGoodsid());
			System.out.println("��Ʒ��="+goods.getName());

			
			r.setCode(0);
			r.setMessage("���ͳɹ���1024xuan");
			
			//���ص�ַ��HTTP://localhost:8080/gdms-web/rest/hongyan/goods/push/one
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			r.setCode(521024);
			r.setMessage("������Ʒʧ�ܣ�"+jsonparam);
		}
		return r;
		
	}
	
	@Path("/goods/push/two")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity pushGoodsTuisong (String jsonparam) {
		
		ResponseEntity r = new ResponseEntity();
		
		try {
			JSONObject j =JSONObject.parseObject(jsonparam);
			String gs = j.getString("goods");
			GoodsModel goods = JSONObject.parseObject(gs,GoodsModel.class);
			System.out.println("������յ�");
			System.out.println("��Ʒid="+goods.getGoodsid());
			System.out.println("��Ʒ��="+goods.getName());
			
			GoodsService service = (GoodsService) Factory.getInstance().getObject("");
			int count = service.add(goods);
			
			r.setCode(0);
			r.setMessage("���ͳɹ���1024xuan");
			
			//���ص�ַ��HTTP://localhost:8080/gdms-web/rest/hongyan/goods/push/tow
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			r.setCode(521024);
			r.setMessage("������Ʒʧ�ܣ�"+jsonparam);
		}
		return r;
		
		
	}
}
