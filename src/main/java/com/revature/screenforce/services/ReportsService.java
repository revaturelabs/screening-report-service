package com.revature.screenforce.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.beans.Track;
import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.feign.*;
import com.revature.screenforce.models.CategoryModel;
import com.revature.screenforce.models.FullReportModel;
import com.revature.screenforce.models.QuestionModel;
import com.revature.screenforce.models.SimpleReportModel;
import com.revature.screenforce.models.ViolationModel;

@Service
public class ReportsService {
	
	@Autowired FeignCategory feignCategory;
	@Autowired FeignQuestion feignQuestion;
	@Autowired FeignQuestionScore feignQuestionScore;
	@Autowired FeignScheduledScreening feignScheduledScreening;
	@Autowired FeignScreening feignScreening;
	@Autowired FeignTrack feignTrack;
	@Autowired FeignSoftSkillViolation feignSoftSkillViolation;
	@Autowired FeignViolationType feignViolationType;
	@Autowired FeignWeight feignWeight;
	
	private List<ViolationModel> makeViolationModel(Screening scr){
	List<ViolationModel> vm = new ArrayList<ViolationModel>();
	List<SoftSkillViolation> ssv= feignSoftSkillViolation.getSoftSkillViolations();
	for(SoftSkillViolation s : ssv) {
		if(s.getScreening().getScreeningId()==scr.getScreeningId()) {
			vm.add(new ViolationModel(s));
		}
	}

	return vm;
	}
	
	private List<CategoryModel> makeCategoryModel(Screening scr){
		List<CategoryModel> cm = new ArrayList<CategoryModel>();
		List<QuestionScore> qs = feignQuestionScore.getScoresByScreeningId(new Integer(scr.getScreeningId()));
		for(QuestionScore q:qs) {
			boolean bucketExist = false;
			for(CategoryModel b:cm ) {
				
				//If bucket exist, just add question into bucket
				if(b.getCategoryId()==q.getCategoryId()) {
					bucketExist=true;
					List<QuestionModel> qmlist = b.getQuestion();
					QuestionModel qm = new QuestionModel(feignQuestion.getQuestionById(new Integer(q.getQuestionId())));
					qm.setScore(q.getScore());
					qm.setQuestionComment(q.getComment());
					qmlist.add(qm);
					b.setQuestion(qmlist);
				}
			}
			//if bucket doesn't exist, add bucket and question
			if( bucketExist == false) {
				CategoryModel in = new CategoryModel(feignCategory.getCategoryByCategoryId(new Integer(q.getCategoryId())));
				Weight w = feignWeight.getWeightFromIds(new Integer(scr.getTrack()), new Integer(q.getCategoryId()));
				in.setWeightValue(w.getWeightValue());
				
				//add Question 
				QuestionModel qm = new QuestionModel(feignQuestion.getQuestionById(q.getQuestionId()));
				qm.setScore(q.getScore());
				qm.setQuestionComment(q.getComment());
				List<QuestionModel> qmlist = new ArrayList<QuestionModel>();
				qmlist.add(qm);
				in.setQuestion(qmlist);
				cm.add(in);
			}
			
		}
		for(CategoryModel c2: cm) {
			int counter = 0;
			double score = 0;
			for(QuestionModel qm2:c2.getQuestion() ) {
				score += qm2.getScore();
				counter++;
			}
			c2.setAverageQuestionScore(score/counter);
		}
		return cm;	
	}
	public FullReportModel createFullReportModel(int screeningId) {
		
		Screening scr = feignScreening.getScreeningById(screeningId);
		SimpleReportModel srm = createSimpleModel(scr);
		FullReportModel frm = new FullReportModel(srm);
		frm.setAboutMeCommentary(scr.getAboutMeCommentary());
		frm.setGeneralCommentary(scr.getSoftSkillCommentary());
		frm.setSoftSkillCommentary(scr.getSoftSkillCommentary());
		frm.setCan(scr.getScheduledScreening().getCandidate());
		frm.setScreener_id(scr.getScreenerId());
		frm.setSoftSkillVerdict(scr.getSoftSkillsVerdict());
		frm.setCategoryModel(makeCategoryModel(scr));
		frm.setViolation(makeViolationModel(scr));
		return frm;
	}
	public SimpleReportModel createSimpleModel(Screening scr) {
		Track track = feignTrack.getTrackById(scr.getTrack());
		SimpleReportModel out = new SimpleReportModel(scr,track);
		return out;
	}
	public List<SimpleReportModel> getSimpleReportModelByRange(Date start, Date end){
		List<SimpleReportModel> out = new ArrayList<SimpleReportModel>();
		List<Screening> test = feignScreening.getAllScreening();
		for(Screening s:test) {
			if( s.getScheduledScreening().getScheduledStatus().compareTo(ScheduledStatus.SCREENED)==0 	&&
					(s.getStartDateTime().after(start) && s.getStartDateTime().before(end))){
				out.add(createSimpleModel(s));
			}
		}
		return out;
	}

}




