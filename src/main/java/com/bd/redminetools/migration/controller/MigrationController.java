package com.bd.redminetools.migration.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bd.redminetools.migration.domain.Journals;
import com.bd.redminetools.migration.service.MigrationService;

@RestController
public class MigrationController {

	@Autowired(required=true)
	MigrationService service;
	

	@RequestMapping(value = "/migration/api/issuesAuthoringInfoMigration", method = RequestMethod.POST)
	public String allCopiedIssuesAuthoringInfoMigration(@RequestBody HashMap<String, Object> map) {
		
		//String inputData = sourceProjectId + ":" + targetProjectId + ":" + copyExecuteUserId + ":" + copyTimeStr;
		String sourceProjectId = (String) map.get("sourceProjectId");
		String targetProjectId = (String) map.get("targetProjectId");
		String copyExecuteUserId = (String) map.get("copyExecuteUserId");
		String copyTimeStr = (String) map.get("copyTimeStr");
		
		boolean effected = service.migrateAuthoringInfo(sourceProjectId, copyExecuteUserId, targetProjectId, copyTimeStr);
		
		if(effected == true) {
			System.out.println(" ##### 저자 및 저작시간 Migration 성공");
			
			return "success";
		}else {
			System.out.println(" ##### 저자 및 저작시간 Migration 실패 : 조건에 맞는 데이터 없슴");
			
			return "fail";
		}
	}
	
	/**
	 * 레드마인 프로젝트 복제 후 기존 프로젝트의 개별 일감에 대한 이력을 새 프로젝트로 복제해 주는 API
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/migration/api/issuesHistoryMigration", method = RequestMethod.POST)
	public String allCopiedIssuesHistoryMigration(@RequestBody HashMap<String, Object> map) {
		
		String sourceProjectId = (String) map.get("sourceProjectId");
		String targetProjectId = (String) map.get("targetProjectId");
		String copyTimeStr = (String) map.get("copyTimeStr");
		
		int skipCount = 0;
		List<Journals> journalList  = service.getJournals(sourceProjectId, targetProjectId, copyTimeStr);
		if(journalList != null) {
			System.out.println(">>>>> journalList.size()=" + journalList.size());
			
			for(int i = 0; i < journalList.size(); i++){
				Journals journal = (Journals)journalList.get(i);
				boolean saved = service.createJournalAndCopyOldDetails(journal);
				if(saved != true) {
					skipCount++;
					System.out.println("$$$$$ SKIPPED Journal : " + journal);
				}
			}
			System.out.println(">>>>> skipCount=" + skipCount);
				
			if(skipCount == journalList.size()) {
				if(skipCount > 0 && journalList.size() > 0) {
					System.out.println(" ##### 일감 이력 Migration 실패 : 모두 중복되어 Skip 처리됨");
				}else {
					System.out.println(" ##### 일감 이력 Migration 실패 : 조건에 맞는 데이터 없슴");
				}
				
				return "fail";
			}else {
				System.out.println(" ##### 일감 이력 Migration 성공");
				return "success";
			}
		}else {
			System.out.println(" ##### 일감 이력 Migration 실패 : 조건에 맞는 데이터 없슴");
			
			return "fail";
		}
	}	
}
