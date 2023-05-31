/**
 * 레드마인 프로젝트 복제 후 기존 프로젝트의 개별 일감에 대한 이력 복사 또는 저자/저작시간 Migration 데이터 처리
 */
package com.bd.redminetools.migration.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bd.redminetools.migration.domain.JournalDetails;
import com.bd.redminetools.migration.domain.Journals;

/**
 * @author yaong
 *
 */
@Repository
public class MigrationRepository {

	@Autowired(required=true)
	private SqlSession sqlSession;
	
	private String ns = "com.bd.redminetools.migration.mapper.MigrationMapper.";
	
	/**
	 * 복사된 프로젝트의 일감 목록들에 부합하는 원본 프로젝트의 저널목록 추출
	 * @param sourceProjectId
	 * @param targetProjectId
	 * @return
	 */
	public List<Journals> getJournalList(String sourceProjectId, String targetProjectId, String copyTimeStr) {
		if(sourceProjectId == null || targetProjectId == null) {
			return null;
		}
		
		HashMap<String, Object> argMap = new HashMap<String, Object>();
		argMap.put("sourceProjectId", sourceProjectId);
		argMap.put("targetProjectId", targetProjectId);
		argMap.put("copyTimeStr", copyTimeStr);
		return sqlSession.selectList(ns + "selectJournals", argMap);
	}
	
	/**
	 * 동일한 저널의 기 존재 여부 확인
	 * @param journals
	 * @return
	 */
	public boolean existSameJournal(Journals journals) {
		if(journals == null) {
			return false;
		}
		
		boolean result = false;
		
		try {
			int effectedCnt = sqlSession.selectOne(ns + "selectSameJournalCount", journals);
			if(effectedCnt > 0) {
				result = true;
			}else {
				 result = false;
			}				
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return result;		
	}
	
	/**
	 * 복제된 프로젝트의 개별 일감에 원본 프로젝트의 해당 일감 저널 복사 
	 * @param journals
	 * @return
	 */
	public boolean addJournal(Journals journals) {
		if(journals == null) {
			return false;
		}
		
		boolean result = false;
		
		try {
			int effectedCnt = sqlSession.insert(ns + "insertJournal", journals);
			if(effectedCnt > 0) {
				result = true;
			}else {
				 result = false;
			}				
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}

	/**
	 * 복제본 프로젝트에 복제생성된 신규 저널 ID 추출
	 * @param oldJournalId
	 * @return
	 */
	public int getLastJournalId(int oldJournalId) {
		if(oldJournalId == 0) {
			return 0;
		}
		
		return sqlSession.selectOne(ns + "selectLastJournalId", oldJournalId);
	}
	
	/**
	 * 저널상세 원본 추출
	 * @param oldJournalId
	 * @return
	 */
	public List<JournalDetails> getOldDetails(int oldJournalId) {
		if(oldJournalId == 0) {
			return null;
		}
		
		return sqlSession.selectList(ns + "selectOldDetails", oldJournalId);
	}
	
	/**
	 * 복제본 프로젝트에 원본 프로젝트의 저널상세 복사
	 * @param details
	 * @return
	 */
	public boolean addJournalDetails(JournalDetails details) {
		if(details == null) {
			return false;
		}
		
		boolean result = false;
		
		try {
			int effectedCnt = sqlSession.insert(ns + "insertJournalDetails", details);
			if(effectedCnt > 0) {
				result = true;
			}else {
				 result = false;
			}			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}	
	
	/**
	 * 기존 프로젝트의 일감 별 저자, 상태, 저작시간 정보를, 새 프로젝트의 제목으로 Matching되는 각각의 일감으로 복사
	 * @param sourceProjectId
	 * @param copyExecuteUserId
	 * @param targetProjectId
	 * @param copyTimeStr
	 * @return
	 */
	public boolean modifyAuthoringInfo(String sourceProjectId, String copyExecuteUserId, String targetProjectId, String copyTimeStr) {
		if(sourceProjectId == null || copyExecuteUserId == null || targetProjectId == null || copyTimeStr == null) {
			return false;
		}
		
		boolean result = false;
		
		HashMap<String, Object> argMap = new HashMap<String, Object>();
		argMap.put("sourceProjectId", sourceProjectId);
		argMap.put("targetProjectId", targetProjectId);
		argMap.put("copyExecuteUserId", copyExecuteUserId);	
		argMap.put("copyTimeStr", copyTimeStr);
		
		try {
			int effectedCnt = sqlSession.update(ns + "updateAuthoringInfo", argMap);
			if(effectedCnt > 0) {
				result = true;
			}else {
				 result = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return result;		
	}
}
