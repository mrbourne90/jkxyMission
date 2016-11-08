package com.vipmanage.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vipmanage.model.Vip;
import com.vipmanage.service.VipService;

@Controller
@Scope("prototype")
public class VipAction extends ActionSupport implements ModelDriven<Vip> {

	@Resource
	private VipService vipService;
	private static final long serialVersionUID = 1L;
	private Vip vip = new Vip();
	private int pageNo;

	public String add() {
		vip.setJoinTime(new Date());
		vipService.add(vip);
		return "add_success";
	}

	public String browse() {

		Page<Vip> vipPage = vipService.getVipsWithPage(pageNo, 5);
		if (vipPage != null) {
			Map session = (Map) ActionContext.getContext().getSession();
			session.put("vipPage", vipPage);
			return "browse_success";
		} else {
			return "browse_error";
		}

	}

	public String findOne() {

		Vip vipResult = vipService.findOne(vip.getVipId());
		if (vipResult != null) {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("vipResult", vipResult);
			return "find_success";
		} else {
			return "find_error";
		}
	}

	@Override
	public Vip getModel() {
		return vip;
	}

	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	public VipService getVipService() {
		return vipService;
	}

	public void setVipService(VipService vipService) {
		this.vipService = vipService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
