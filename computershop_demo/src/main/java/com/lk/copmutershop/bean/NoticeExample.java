package com.lk.copmutershop.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andNoticeIdIsNull() {
            addCriterion("Notice_Id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("Notice_Id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(Integer value) {
            addCriterion("Notice_Id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(Integer value) {
            addCriterion("Notice_Id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(Integer value) {
            addCriterion("Notice_Id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Notice_Id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(Integer value) {
            addCriterion("Notice_Id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(Integer value) {
            addCriterion("Notice_Id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<Integer> values) {
            addCriterion("Notice_Id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<Integer> values) {
            addCriterion("Notice_Id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(Integer value1, Integer value2) {
            addCriterion("Notice_Id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Notice_Id not between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andWordsTitleIsNull() {
            addCriterion("Words_title is null");
            return (Criteria) this;
        }

        public Criteria andWordsTitleIsNotNull() {
            addCriterion("Words_title is not null");
            return (Criteria) this;
        }

        public Criteria andWordsTitleEqualTo(String value) {
            addCriterion("Words_title =", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleNotEqualTo(String value) {
            addCriterion("Words_title <>", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleGreaterThan(String value) {
            addCriterion("Words_title >", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Words_title >=", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleLessThan(String value) {
            addCriterion("Words_title <", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleLessThanOrEqualTo(String value) {
            addCriterion("Words_title <=", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleLike(String value) {
            addCriterion("Words_title like", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleNotLike(String value) {
            addCriterion("Words_title not like", value, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleIn(List<String> values) {
            addCriterion("Words_title in", values, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleNotIn(List<String> values) {
            addCriterion("Words_title not in", values, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleBetween(String value1, String value2) {
            addCriterion("Words_title between", value1, value2, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsTitleNotBetween(String value1, String value2) {
            addCriterion("Words_title not between", value1, value2, "wordsTitle");
            return (Criteria) this;
        }

        public Criteria andWordsContentIsNull() {
            addCriterion("Words_content is null");
            return (Criteria) this;
        }

        public Criteria andWordsContentIsNotNull() {
            addCriterion("Words_content is not null");
            return (Criteria) this;
        }

        public Criteria andWordsContentEqualTo(String value) {
            addCriterion("Words_content =", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentNotEqualTo(String value) {
            addCriterion("Words_content <>", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentGreaterThan(String value) {
            addCriterion("Words_content >", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentGreaterThanOrEqualTo(String value) {
            addCriterion("Words_content >=", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentLessThan(String value) {
            addCriterion("Words_content <", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentLessThanOrEqualTo(String value) {
            addCriterion("Words_content <=", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentLike(String value) {
            addCriterion("Words_content like", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentNotLike(String value) {
            addCriterion("Words_content not like", value, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentIn(List<String> values) {
            addCriterion("Words_content in", values, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentNotIn(List<String> values) {
            addCriterion("Words_content not in", values, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentBetween(String value1, String value2) {
            addCriterion("Words_content between", value1, value2, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsContentNotBetween(String value1, String value2) {
            addCriterion("Words_content not between", value1, value2, "wordsContent");
            return (Criteria) this;
        }

        public Criteria andWordsTimeIsNull() {
            addCriterion("Words_time is null");
            return (Criteria) this;
        }

        public Criteria andWordsTimeIsNotNull() {
            addCriterion("Words_time is not null");
            return (Criteria) this;
        }

        public Criteria andWordsTimeEqualTo(Date value) {
            addCriterionForJDBCDate("Words_time =", value, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("Words_time <>", value, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("Words_time >", value, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Words_time >=", value, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeLessThan(Date value) {
            addCriterionForJDBCDate("Words_time <", value, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Words_time <=", value, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeIn(List<Date> values) {
            addCriterionForJDBCDate("Words_time in", values, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("Words_time not in", values, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Words_time between", value1, value2, "wordsTime");
            return (Criteria) this;
        }

        public Criteria andWordsTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Words_time not between", value1, value2, "wordsTime");
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