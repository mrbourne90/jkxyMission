package com.vipmanage.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vipmanage.model.Commodity;
import com.vipmanage.service.CommodityService;

@Controller("commodityAction")
@Scope("prototype")
public class CommodityAction extends ActionSupport implements ModelDriven<Commodity> {

	@Resource
	private CommodityService commodityService;
	private static final long serialVersionUID = 1L;
	private Commodity commodity = new Commodity();
	private int pageNo;

	// 添加新商品
	public String add() {
		// 将商品持久化到数据库中
		Commodity addCommodity = commodityService.add(this.commodity);
		// 将成功加入的欣商品添加到Session中
		Map session = ActionContext.getContext().getSession();
		session.put("addCommodity", addCommodity);
		return "add_success";
	}

	// 根据id查找商品信息｛
	public String findOne() {
		// 如果有指定商品那么输出商品信息，否则提示错误
		System.out.println("输入id:" + commodity.getCommodityId());
		Commodity commodityResult = commodityService.findOne(commodity.getCommodityId());
		Map request = (Map) ActionContext.getContext().get("request");
		if (commodityResult != null) {
			request.put("commodityResult", commodityResult);
			return "findOne_success";
		} else {
			return "findOne_error";
		}
	}

	// 查询商品信息
	public String browse() {

		// 将分页后的数据查询出来并放入request中
		Page<Commodity> commodityPage = commodityService.getCommoditiesWithPage(pageNo, 7);
		if (commodityPage != null) {
			Map session = ActionContext.getContext().getSession();
			session.put("commodityPage", commodityPage);
			return "browse_success";
		} else {
			return "browse_error";
		}
	}

	@Override
	public Commodity getModel() {
		return commodity;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
