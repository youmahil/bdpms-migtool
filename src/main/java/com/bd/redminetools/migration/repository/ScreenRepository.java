/**
 * 레드마인 프로젝트 마이그레이션 지원 화면용
 */
package com.bd.redminetools.migration.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bd.redminetools.migration.domain.Project;
import com.bd.redminetools.migration.domain.User;

/**
 * @author yaong
 *
 */
@Repository
public class ScreenRepository {
	@Autowired(required=true)
	private SqlSession sqlSession;
	
	private String ns = "com.bd.redminetools.migration.mapper.ScreenMapper.";
	
	/**
	 * 레드마인 프로젝트 목록 추출
	 * @return
	 */
	public List<Project> getProjectList(){
		return sqlSession.selectList(ns + "selectProjects");
	}
	
	/**
	 * 레드마인 활성 사용자 목록 추출
	 * @return
	 */
	public List<User> getActiveUserList(){
		return sqlSession.selectList(ns + "selectActiveUsers");
	}
	
	/**
	 * 선택된 복사본 프로젝트에 소속된 일감들의 생성시간 목록 추출
	 * @param projectId
	 * @return
	 */
	public List<String> getCopyTimeString(int projectId){
		return sqlSession.selectList(ns + "selectTargetIssuesTimeList", projectId);
	}
}
