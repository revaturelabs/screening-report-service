package com.revature.screenforce.dtos;

import java.io.Serializable;
import java.util.Objects;



//5/27 JU - body from admin application

public class Question implements Serializable {

    private static final long serialVersionUID = -6987859794752419355L;

 
    private int questionId;


    private Bucket bucket;

  
    private boolean isActive;

 
    private String questionText;

    private String sampleAnswer1;


    private String sampleAnswer2;


    private String sampleAnswer3;


    private String sampleAnswer4;


    private String sampleAnswer5;

    public Question() {
        super();
    }

    public Question(Integer questionId, Bucket bucket, Boolean isActive, String questionText, String sampleAnswer1,
                    String sampleAnswer2, String sampleAnswer3, String sampleAnswer4, String sampleAnswer5) {
        super();
        this.questionId = questionId;
        this.bucket = bucket;
        this.isActive = isActive;
        this.questionText = questionText;
        this.sampleAnswer1 = sampleAnswer1;
        this.sampleAnswer2 = sampleAnswer2;
        this.sampleAnswer3 = sampleAnswer3;
        this.sampleAnswer4 = sampleAnswer4;
        this.sampleAnswer5 = sampleAnswer5;
    }

    /**
     * Getters and setters
     */
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getSampleAnswer1() {
        return sampleAnswer1;
    }

    public void setSampleAnswer1(String sampleAnswer1) {
        this.sampleAnswer1 = sampleAnswer1;
    }

    public String getSampleAnswer2() {
        return sampleAnswer2;
    }

    public void setSampleAnswer2(String sampleAnswer2) {
        this.sampleAnswer2 = sampleAnswer2;
    }

    public String getSampleAnswer3() {
        return sampleAnswer3;
    }

    public void setSampleAnswer3(String sampleAnswer3) {
        this.sampleAnswer3 = sampleAnswer3;
    }

    public String getSampleAnswer4() {
        return sampleAnswer4;
    }

    public void setSampleAnswer4(String sampleAnswer4) {
        this.sampleAnswer4 = sampleAnswer4;
    }

    public String getSampleAnswer5() {
        return sampleAnswer5;
    }

    public void setSampleAnswer5(String sampleAnswer5) {
        this.sampleAnswer5 = sampleAnswer5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(getQuestionId(), question.getQuestionId()) &&
                Objects.equals(getBucket(), question.getBucket()) &&
                Objects.equals(getIsActive(), question.getIsActive()) &&
                Objects.equals(getQuestionText(), question.getQuestionText()) &&
                Objects.equals(getSampleAnswer1(), question.getSampleAnswer1()) &&
                Objects.equals(getSampleAnswer2(), question.getSampleAnswer2()) &&
                Objects.equals(getSampleAnswer3(), question.getSampleAnswer3()) &&
                Objects.equals(getSampleAnswer4(), question.getSampleAnswer4()) &&
                Objects.equals(getSampleAnswer5(), question.getSampleAnswer5());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getBucket(), getIsActive(), getQuestionText(), getSampleAnswer1(), getSampleAnswer2(), getSampleAnswer3(), getSampleAnswer4(), getSampleAnswer5());
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", bucket=" + bucket +
                ", isActive=" + isActive +
                ", questionText='" + questionText + '\'' +
                ", sampleAnswer1='" + sampleAnswer1 + '\'' +
                ", sampleAnswer2='" + sampleAnswer2 + '\'' +
                ", sampleAnswer3='" + sampleAnswer3 + '\'' +
                ", sampleAnswer4='" + sampleAnswer4 + '\'' +
                ", sampleAnswer5='" + sampleAnswer5 + '\'' +
                '}';
    }
}