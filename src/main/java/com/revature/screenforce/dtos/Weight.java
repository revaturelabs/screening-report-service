package com.revature.screenforce.dtos;

import java.util.Objects;


//5/27 JU - body from admin application

public class Weight {


    private int weightId;


    private int weightValue;


    private SkillType skillType;


    private Bucket bucket;

    public Weight() {
        super();
    }

    public Weight(int weightId, int weightValue, SkillType skillType, Bucket bucket) {
        super();
        this.weightId = weightId;
        this.weightValue = weightValue;
        this.skillType = skillType;
        this.bucket = bucket;
    }

    /**
     * Getters and setters
     */
    public int getWeightId() {
        return weightId;
    }

    public void setWeightId(int weightId) {
        this.weightId = weightId;
    }

    public int getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(int weightValue) {
        this.weightValue = weightValue;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight1 = (Weight) o;
        return getWeightId() == weight1.getWeightId() &&
                getWeightValue() == weight1.getWeightValue() &&
                getSkillType() == weight1.getSkillType() &&
                getBucket() == weight1.getBucket();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeightId(), getWeightValue(), getSkillType(), getBucket());
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weightId=" + weightId +
                ", weightValue=" + weightValue +
                ", skillType=" + skillType +
                ", bucket=" + bucket +
                '}';
    }
}
