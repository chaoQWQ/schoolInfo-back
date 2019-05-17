package com.zc.schoolinfo.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolunteerActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VolunteerActivityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitileIsNull() {
            addCriterion("titile is null");
            return (Criteria) this;
        }

        public Criteria andTitileIsNotNull() {
            addCriterion("titile is not null");
            return (Criteria) this;
        }

        public Criteria andTitileEqualTo(String value) {
            addCriterion("titile =", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotEqualTo(String value) {
            addCriterion("titile <>", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileGreaterThan(String value) {
            addCriterion("titile >", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileGreaterThanOrEqualTo(String value) {
            addCriterion("titile >=", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileLessThan(String value) {
            addCriterion("titile <", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileLessThanOrEqualTo(String value) {
            addCriterion("titile <=", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileLike(String value) {
            addCriterion("titile like", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotLike(String value) {
            addCriterion("titile not like", value, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileIn(List<String> values) {
            addCriterion("titile in", values, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotIn(List<String> values) {
            addCriterion("titile not in", values, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileBetween(String value1, String value2) {
            addCriterion("titile between", value1, value2, "titile");
            return (Criteria) this;
        }

        public Criteria andTitileNotBetween(String value1, String value2) {
            addCriterion("titile not between", value1, value2, "titile");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeIsNull() {
            addCriterion("recruit_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeIsNotNull() {
            addCriterion("recruit_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeEqualTo(Date value) {
            addCriterion("recruit_start_time =", value, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeNotEqualTo(Date value) {
            addCriterion("recruit_start_time <>", value, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeGreaterThan(Date value) {
            addCriterion("recruit_start_time >", value, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recruit_start_time >=", value, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeLessThan(Date value) {
            addCriterion("recruit_start_time <", value, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("recruit_start_time <=", value, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeIn(List<Date> values) {
            addCriterion("recruit_start_time in", values, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeNotIn(List<Date> values) {
            addCriterion("recruit_start_time not in", values, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeBetween(Date value1, Date value2) {
            addCriterion("recruit_start_time between", value1, value2, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("recruit_start_time not between", value1, value2, "recruitStartTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeIsNull() {
            addCriterion("recruit_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeIsNotNull() {
            addCriterion("recruit_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeEqualTo(Date value) {
            addCriterion("recruit_end_time =", value, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeNotEqualTo(Date value) {
            addCriterion("recruit_end_time <>", value, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeGreaterThan(Date value) {
            addCriterion("recruit_end_time >", value, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recruit_end_time >=", value, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeLessThan(Date value) {
            addCriterion("recruit_end_time <", value, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("recruit_end_time <=", value, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeIn(List<Date> values) {
            addCriterion("recruit_end_time in", values, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeNotIn(List<Date> values) {
            addCriterion("recruit_end_time not in", values, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeBetween(Date value1, Date value2) {
            addCriterion("recruit_end_time between", value1, value2, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andRecruitEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("recruit_end_time not between", value1, value2, "recruitEndTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersIsNull() {
            addCriterion("join_numbers is null");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersIsNotNull() {
            addCriterion("join_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersEqualTo(Integer value) {
            addCriterion("join_numbers =", value, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersNotEqualTo(Integer value) {
            addCriterion("join_numbers <>", value, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersGreaterThan(Integer value) {
            addCriterion("join_numbers >", value, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_numbers >=", value, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersLessThan(Integer value) {
            addCriterion("join_numbers <", value, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersLessThanOrEqualTo(Integer value) {
            addCriterion("join_numbers <=", value, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersIn(List<Integer> values) {
            addCriterion("join_numbers in", values, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersNotIn(List<Integer> values) {
            addCriterion("join_numbers not in", values, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersBetween(Integer value1, Integer value2) {
            addCriterion("join_numbers between", value1, value2, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andJoinNumbersNotBetween(Integer value1, Integer value2) {
            addCriterion("join_numbers not between", value1, value2, "joinNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersIsNull() {
            addCriterion("recruit_numbers is null");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersIsNotNull() {
            addCriterion("recruit_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersEqualTo(Integer value) {
            addCriterion("recruit_numbers =", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersNotEqualTo(Integer value) {
            addCriterion("recruit_numbers <>", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersGreaterThan(Integer value) {
            addCriterion("recruit_numbers >", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersGreaterThanOrEqualTo(Integer value) {
            addCriterion("recruit_numbers >=", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersLessThan(Integer value) {
            addCriterion("recruit_numbers <", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersLessThanOrEqualTo(Integer value) {
            addCriterion("recruit_numbers <=", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersIn(List<Integer> values) {
            addCriterion("recruit_numbers in", values, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersNotIn(List<Integer> values) {
            addCriterion("recruit_numbers not in", values, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersBetween(Integer value1, Integer value2) {
            addCriterion("recruit_numbers between", value1, value2, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersNotBetween(Integer value1, Integer value2) {
            addCriterion("recruit_numbers not between", value1, value2, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCoverImageIsNull() {
            addCriterion("cover_image is null");
            return (Criteria) this;
        }

        public Criteria andCoverImageIsNotNull() {
            addCriterion("cover_image is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImageEqualTo(String value) {
            addCriterion("cover_image =", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotEqualTo(String value) {
            addCriterion("cover_image <>", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageGreaterThan(String value) {
            addCriterion("cover_image >", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageGreaterThanOrEqualTo(String value) {
            addCriterion("cover_image >=", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLessThan(String value) {
            addCriterion("cover_image <", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLessThanOrEqualTo(String value) {
            addCriterion("cover_image <=", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLike(String value) {
            addCriterion("cover_image like", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotLike(String value) {
            addCriterion("cover_image not like", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageIn(List<String> values) {
            addCriterion("cover_image in", values, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotIn(List<String> values) {
            addCriterion("cover_image not in", values, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageBetween(String value1, String value2) {
            addCriterion("cover_image between", value1, value2, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotBetween(String value1, String value2) {
            addCriterion("cover_image not between", value1, value2, "coverImage");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}