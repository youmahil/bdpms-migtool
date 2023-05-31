/**
 * 
 */
package com.bd.redminetools.migration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bd.redminetools.migration.domain.MigrationSettings;
import com.bd.redminetools.migration.domain.Project;
import com.bd.redminetools.migration.domain.User;
import com.bd.redminetools.migration.service.ScreenService;

/**
 * @author yaong
 *
 */
@Controller
public class ScreenController {

	@Autowired(required=true)
	ScreenService service;
	
	@RequestMapping(value = "/migration/screen/main", method = RequestMethod.GET)
	public String migrationHome() {
		System.out.println(" %%%%% 메인 화면 표시");
		
		return "index";
	}
	
	/**
	 * Migration도구 화면에 표시될 프로젝트 및 사용자 목록 데이터 추출
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/migration/screen/getBaseData", method = RequestMethod.POST)
	public String getBaseData(@ModelAttribute  MigrationSettings body, Model model) {
		if(body == null) {
			System.out.println(" %%%%% 요청 데이터가 없음, 기본으로 메인 화면 표시");
			return "index";
		}
		
		String migType = body.getMigType();
		
		// 전체 프로젝트 목록을 추출한다.
		List<Project> projects = service.getProjects();
		
		// 활성 사용자 목록을 추출한다.
		List<User> users = service.getActiveUsers();
		
		model.addAttribute("projects", projects);
		model.addAttribute("users", users);
		
		model.addAttribute("migType", migType);
		
		String pageName = "index";
		if(migType.equals("auth")) {
			System.out.println(" %%%%% 선택 : 저자 정보 및 저작 시간 Migration 화면 표시");
			
			pageName = "auth_mig";
		}else if(migType.equals("hist")) {
			System.out.println(" %%%%% 선택 : 일감별 이력 정보 Migration 화면 표시");
			
			pageName = "hist_mig";
		}else {
			System.out.println(" %%%%% 선택 : Migration 실행 대상 선택 값이 올바르지 않음, 기본으로 메인 화면 표시");
			
			pageName = "index";
		}
		
		return pageName;
	}
	
	/**
	 * 선택된 프로젝트 별 일감들의 시간문자열 목록 추출
	 * @param id
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/screen/getTimeList", method = RequestMethod.GET)
	public List<String> getTimeListByProject(@RequestParam String id, Model model) {
		if(id == null) {
			return null;
		}
		
		System.out.println(" %%%%% 선택된 프로젝트의 시간 목록 추출");
		
		// 프로젝트 별 일감들의 시간문자열 목록을 추출한다
		int projectId = Integer.valueOf(id);
		List<String> timeList = service.getCopyTimes(projectId);
		
		return timeList;
	}
}
