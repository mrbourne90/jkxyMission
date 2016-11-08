package com.vipmanage.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vipmanage.model.Consume;
import com.vipmanage.service.ConsumeService;

@Controller
@Scope("prototype")
public class ConsumeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource
	private ConsumeService consumeService;
	private int pageNo;
	private int vipId;

	public String browse() {

		Page<Consume> consumesPage = consumeService.getConsumesWithPage(pageNo, 8);
		if (consumesPage != null) {
			Map session = ActionContext.getContext().getSession();
			session.put("consumesPage", consumesPage);
			return "browse_success";
		} else {
			return "browse_error";
		}

	}

	public String findByVipId() {

		Page<Consume> vipConsumes = consumeService.getConsumesByVipIdWithPage(vipId, pageNo, 5);
		if (vipConsumes != null) {
			Map session = ActionContext.getContext().getSession();
			session.put("vipConsumes", vipConsumes);
			return "findByVipId_success";
		} else {
			Map session = ActionContext.getContext().getSession();
			session.remove("vipConsumes");
			return "findByVipId_error";
		}

	}

	public ConsumeService getConsumeService() {
		return consumeService;
	}

	public void setConsumeService(ConsumeService consumeService) {
		this.consumeService = consumeService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

}
