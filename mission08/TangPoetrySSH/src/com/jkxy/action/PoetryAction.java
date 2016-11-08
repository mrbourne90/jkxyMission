package com.jkxy.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jkxy.entity.Conditions;
import com.jkxy.entity.Poetries;
import com.jkxy.entity.common.PageModel;
import com.jkxy.service.impl.PoetriesService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("poetryAction")
@Scope("prototype")
public class PoetryAction extends ActionSupport implements ModelDriven<Conditions> {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private Conditions conditions = new Conditions();
	// 查询结果
	private PageModel<Poetries> poetries;
	@Resource
	private PoetriesService pService;

	@Override
	public String execute() throws Exception {

		// 获取查询结果
		poetries = pService.getResults(conditions.getSearchCondition(), conditions.getSearchKey(),
				conditions.getIndex(), 10);
		if (!poetries.getDatas().isEmpty()) {
			return "success";
		} else {
			return "fail";
		}
	}

	public PageModel<Poetries> getPoetries() {
		return poetries;
	}

	public void setPoetries(PageModel<Poetries> poetries) {
		this.poetries = poetries;
	}

	public PoetriesService getpService() {
		return pService;
	}

	public void setpService(PoetriesService pService) {
		this.pService = pService;
	}

	@Override
	public Conditions getModel() {
		return conditions;
	}

	public Conditions getConditions() {
		return conditions;
	}

	public void setConditions(Conditions conditions) {
		this.conditions = conditions;
	}

}
