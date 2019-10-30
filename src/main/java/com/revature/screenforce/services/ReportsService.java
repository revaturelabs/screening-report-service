package com.revature.screenforce.services;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;


import com.google.gson.Gson;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.beans.Screener;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.beans.Track;
import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.feign.*;
import com.revature.screenforce.models.FullReportModel;
import com.revature.screenforce.models.QuestionModel;
import com.revature.screenforce.models.SimpleReportModel;
import com.revature.screenforce.models.ViolationModel;
import com.revature.screenforce.util.Time;

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

//	public List<FullReportModel> getAllReports(Date start, Date end){
//		Date searchStart;
//		Date searchEnd;
//		List<FullReportModel> out = new ArrayList<FullReportModel>();
//		if(end==null) {
//			searchEnd = new Date();
//		}else {
//			searchEnd = end;
//		}
//		if(start==null) {
//			searchStart = new Date(0);
//		}else {
//			searchStart = start;
//		}
//		List<Screening> test = feignscreening.getAllScreening();
//		System.out.println("here3");
//		for(Screening s:test) {
//			if( s.getScheduledScreening().getScheduledStatus().compareTo(ScheduledStatus.SCREENED)==0 	&&
//					(s.getStartDateTime().after(searchStart) && s.getStartDateTime().before(searchEnd))
//					 
//				){
//				out.add(testFullReport(new Integer(s.getScreeningId())));
//				System.out.println("herer");
//			}
//		}
//		
//		
//		return out;
//	}
	
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
//	public FullReportModel testFullReport(Integer Screen_id) {
//		FullReportModel out = new FullReportModel();
//		
//
//		List<SkillType> st = feignskilltype.getSkills();
//		Screening op = feignscreening.getScreeningById(Screen_id);
//		out.setScreening_id(op.getScreeningId());
//		out.setScreener_id(op.getScreenerId());
//		out.setCan(op.getScheduledScreening().getCandidate());
//		out.setScheduleDate(op.getStartDateTime());
//		out.setAboutMeCommentary(op.getAboutMeCommentary());
//		out.setGeneralCommentary(op.getGeneralCommentary());
//		out.setSoftSkillCommentary(op.getSoftSkillCommentary());
//		out.setSoftSkillVerdict(op.getSoftSkillsVerdict());
//		for( SkillType s : st) {
//			if(s.getSkillTypeId()==op.getSkillType()) {
//				out.setSkillType(s.getTitle());
//			}
//		}
//		
//		List<BucketModel> bucketTested = new ArrayList<BucketModel>();
//		List<QuestionScore> qs = feignquestionscore.getScoresByScreeningId(new Integer(op.getScreeningId()));
//		
//		List<ViolationModel> vm = new ArrayList<ViolationModel>();
//		List<SoftSkillViolation> ssv= feignsoftskillviolation.getSoftSkillViolations();
//		
//		for(QuestionScore q:qs) {
//			boolean bucketExist = false;
//			for(BucketModel b:bucketTested ) {
//				
//				//If bucket exist, just add question into bucket
//				if(b.getBucketId()==q.getBucketId()) {
//					bucketExist=true;
//					List<QuestionModel> qmlist = b.getQuestionAsked();
//					QuestionModel qm = new QuestionModel(feignquestion.getQuestionById(new Integer(q.getQuestionId())));
//					qm.setScore(q.getScore());
//					qm.setQuestionComment(q.getComment());
//					qmlist.add(qm);
//					b.setQuestionAsked(qmlist);
//				}
//			}
//			//if bucket doesn't exist, add bucket and question
//			if( bucketExist == false) {
//				BucketModel in = new BucketModel(feignbucket.getBucketByBucketId(new Integer(q.getBucketId())));
//				Weight w = feignweight.getWeightFromIds(new Integer(op.getSkillType()), new Integer(q.getBucketId()));
//				in.setWeightVaule(w.getWeightValue());
//				
//				//add Question 
//				QuestionModel qm = new QuestionModel(feignquestion.getQuestionById(q.getQuestionId()));
//				qm.setScore(q.getScore());
//				qm.setQuestionComment(q.getComment());
//				List<QuestionModel> qmlist = new ArrayList<QuestionModel>();
//				qmlist.add(qm);
//				in.setQuestionAsked(qmlist);
//				bucketTested.add(in);
//			}
//		}

}




