/**
 * 
 */
package com.bd.redminetools.migration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.redminetools.migration.domain.JournalDetails;
import com.bd.redminetools.migration.domain.Journals;
import com.bd.redminetools.migration.repository.MigrationRepository;

/**
 * @author yaong
 *
 */

@Service
public class MigrationService {
	@Autowired
	MigrationRepository repo;
	
	/**
	 * 복사된 프로젝트의 일감 목록들에 부합하는 원본 프로젝트의 저널목록 추출
	 * @param sourceProjectId
	 * @param targetProjectId
	 * @return
	 */
	public List<Journals> getJournals(String sourceProjectId, String targetProjectId, String copyTimeStr){

		if(sourceProjectId == null || targetProjectId == null || copyTimeStr == null) {
			return null;
		}
				
		return repo.getJournalList(sourceProjectId, targetProjectId, copyTimeStr);
	}
	
	/**
	 * 저널을 복사하여 새로 채번된 저널 ID를 Key로 사용하고, 기존 저널 상세들을 복사한다.
	 * @param journal
	 * @return
	 */
	public boolean createJournalAndCopyOldDetails(Journals journal) {
		if(journal == null) {
			return false;
		}
		
		int newJournalId = 0;
		boolean result = false;
		
		try{
			System.out.println("+++++> JOURNALS <" + journal.getJournalizedId() + ">="  + journal.toString());
	
			if(repo.existSameJournal(journal)) {
				System.out.println("@@@@@> EXIST JOURNALS <" + journal.getJournalizedId() + ">="  + journal.toString()
									+ "\n##### Skip it!!!");
				return false;
			}
			
			// Copy Journal into Target Project
			boolean effected = repo.addJournal(journal);
			if(effected == true){
				newJournalId = repo.getLastJournalId(journal.getJournalizedId());
			}
			
			// Fetch it's Old Journal Details
			List<JournalDetails> detailList = repo.getOldDetails(journal.getOldJournalId());

			int effectDetailCnt = 0;
			// Copy Journal Details
			for(int i = 0; i < detailList.size(); i++) {
				JournalDetails detailsOld = detailList.get(i);
				JournalDetails detailsNew = new JournalDetails();
				
				detailsNew.setJournalId(newJournalId);
				detailsNew.setProperty(detailsOld.getProperty());
				detailsNew.setPropKey(detailsOld.getPropKey());
				detailsNew.setOldValue(detailsOld.getOldValue());
				detailsNew.setValue(detailsOld.getValue());
				
				System.out.println("=====> DETAILS NEW >" + i+ ">=" + detailsNew.toString());
				
				boolean effectDetail = repo.addJournalDetails(detailsNew);
				if(effectDetail == true){
					effectDetailCnt++;
					System.out.println("***** Migrated 1 Journal and Details\n" + journal.toString() + "\n" + detailsNew.toString());
				}
			}
			
			if(effected == true){
				if(effectDetailCnt > 0) {
					result = true;
				}else {
					if(detailList.size() == 0) {						
						result = true;
					}else {
						result = false;
					}
				}
			}else {
				result = false;
			}
		}catch(Exception e){
			throw e;
		}	

		return result;
	}
	
	/**
	 * 기존 프로젝트의 일감 별 저자, 상태, 저작시간 정보를, 새 프로젝트의 제목으로 Matching되는 각각의 일감으로 복사한다.
	 * @param sourceProjectId
	 * @param copyExecuteUserId
	 * @param targetProjectId
	 * @param copyTimeStr
	 * @return
	 */
	public boolean migrateAuthoringInfo(String sourceProjectId, String copyExecuteUserId, String targetProjectId, String copyTimeStr) {
		if(sourceProjectId == null || copyExecuteUserId == null || targetProjectId == null || copyTimeStr == null) {
			return false;
		}
		
		boolean effected = repo.modifyAuthoringInfo(sourceProjectId, copyExecuteUserId, targetProjectId, copyTimeStr);
		if(effected == true) {
			return true;
		}else {
			return false;
		}
	}
}
