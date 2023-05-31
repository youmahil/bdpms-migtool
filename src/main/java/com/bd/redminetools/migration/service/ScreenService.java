/**
 * 
 */
package com.bd.redminetools.migration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.redminetools.migration.domain.Project;
import com.bd.redminetools.migration.domain.User;
import com.bd.redminetools.migration.repository.ScreenRepository;

/**
 * @author yaong
 *
 */
@Service
public class ScreenService {
	@Autowired
	ScreenRepository repo;
	
	/**
	 * 레드마인 프로젝트 목록 추출
	 * @return
	 */
	public List<Project> getProjects(){
		return repo.getProjectList();
	}
	
	/**
	 * 레드마인 활성 사용자 목록 추출
	 * @return
	 */
	public List<User> getActiveUsers(){
		return repo.getActiveUserList();
	}
	
	/**
	 * 선택된 복사본 프로젝트에 소속된 일감들의 생성시간 목록 추출
	 * @param projectId
	 * @return
	 */
	public List<String> getCopyTimes(int projectId){
		return repo.getCopyTimeString(projectId);
	}
}
