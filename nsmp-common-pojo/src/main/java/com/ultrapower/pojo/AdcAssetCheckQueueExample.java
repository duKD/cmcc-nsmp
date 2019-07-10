package com.ultrapower.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdcAssetCheckQueueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdcAssetCheckQueueExample() {
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

        public Criteria andPkAssetCheckQueueIsNull() {
            addCriterion("PK_ASSET_CHECK_QUEUE is null");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueIsNotNull() {
            addCriterion("PK_ASSET_CHECK_QUEUE is not null");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueEqualTo(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE =", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueNotEqualTo(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE <>", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueGreaterThan(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE >", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE >=", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueLessThan(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE <", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueLessThanOrEqualTo(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE <=", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueLike(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE like", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueNotLike(String value) {
            addCriterion("PK_ASSET_CHECK_QUEUE not like", value, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueIn(List<String> values) {
            addCriterion("PK_ASSET_CHECK_QUEUE in", values, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueNotIn(List<String> values) {
            addCriterion("PK_ASSET_CHECK_QUEUE not in", values, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueBetween(String value1, String value2) {
            addCriterion("PK_ASSET_CHECK_QUEUE between", value1, value2, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andPkAssetCheckQueueNotBetween(String value1, String value2) {
            addCriterion("PK_ASSET_CHECK_QUEUE not between", value1, value2, "pkAssetCheckQueue");
            return (Criteria) this;
        }

        public Criteria andProvCodeIsNull() {
            addCriterion("PROV_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvCodeIsNotNull() {
            addCriterion("PROV_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvCodeEqualTo(String value) {
            addCriterion("PROV_CODE =", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotEqualTo(String value) {
            addCriterion("PROV_CODE <>", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeGreaterThan(String value) {
            addCriterion("PROV_CODE >", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROV_CODE >=", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLessThan(String value) {
            addCriterion("PROV_CODE <", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLessThanOrEqualTo(String value) {
            addCriterion("PROV_CODE <=", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLike(String value) {
            addCriterion("PROV_CODE like", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotLike(String value) {
            addCriterion("PROV_CODE not like", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeIn(List<String> values) {
            addCriterion("PROV_CODE in", values, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotIn(List<String> values) {
            addCriterion("PROV_CODE not in", values, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeBetween(String value1, String value2) {
            addCriterion("PROV_CODE between", value1, value2, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotBetween(String value1, String value2) {
            addCriterion("PROV_CODE not between", value1, value2, "provCode");
            return (Criteria) this;
        }

        public Criteria andPkAssetIsNull() {
            addCriterion("PK_ASSET is null");
            return (Criteria) this;
        }

        public Criteria andPkAssetIsNotNull() {
            addCriterion("PK_ASSET is not null");
            return (Criteria) this;
        }

        public Criteria andPkAssetEqualTo(String value) {
            addCriterion("PK_ASSET =", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotEqualTo(String value) {
            addCriterion("PK_ASSET <>", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetGreaterThan(String value) {
            addCriterion("PK_ASSET >", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ASSET >=", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetLessThan(String value) {
            addCriterion("PK_ASSET <", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetLessThanOrEqualTo(String value) {
            addCriterion("PK_ASSET <=", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetLike(String value) {
            addCriterion("PK_ASSET like", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotLike(String value) {
            addCriterion("PK_ASSET not like", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetIn(List<String> values) {
            addCriterion("PK_ASSET in", values, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotIn(List<String> values) {
            addCriterion("PK_ASSET not in", values, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetBetween(String value1, String value2) {
            addCriterion("PK_ASSET between", value1, value2, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotBetween(String value1, String value2) {
            addCriterion("PK_ASSET not between", value1, value2, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPullTimeIsNull() {
            addCriterion("PULL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPullTimeIsNotNull() {
            addCriterion("PULL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPullTimeEqualTo(Date value) {
            addCriterion("PULL_TIME =", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeNotEqualTo(Date value) {
            addCriterion("PULL_TIME <>", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeGreaterThan(Date value) {
            addCriterion("PULL_TIME >", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PULL_TIME >=", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeLessThan(Date value) {
            addCriterion("PULL_TIME <", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeLessThanOrEqualTo(Date value) {
            addCriterion("PULL_TIME <=", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeIn(List<Date> values) {
            addCriterion("PULL_TIME in", values, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeNotIn(List<Date> values) {
            addCriterion("PULL_TIME not in", values, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeBetween(Date value1, Date value2) {
            addCriterion("PULL_TIME between", value1, value2, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeNotBetween(Date value1, Date value2) {
            addCriterion("PULL_TIME not between", value1, value2, "pullTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("HANDLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("HANDLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("HANDLE_TIME =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("HANDLE_TIME <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("HANDLE_TIME >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("HANDLE_TIME >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("HANDLE_TIME <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("HANDLE_TIME <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("HANDLE_TIME in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("HANDLE_TIME not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("HANDLE_TIME between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("HANDLE_TIME not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimesIsNull() {
            addCriterion("HANDLE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimesIsNotNull() {
            addCriterion("HANDLE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimesEqualTo(Integer value) {
            addCriterion("HANDLE_TIMES =", value, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesNotEqualTo(Integer value) {
            addCriterion("HANDLE_TIMES <>", value, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesGreaterThan(Integer value) {
            addCriterion("HANDLE_TIMES >", value, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("HANDLE_TIMES >=", value, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesLessThan(Integer value) {
            addCriterion("HANDLE_TIMES <", value, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesLessThanOrEqualTo(Integer value) {
            addCriterion("HANDLE_TIMES <=", value, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesIn(List<Integer> values) {
            addCriterion("HANDLE_TIMES in", values, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesNotIn(List<Integer> values) {
            addCriterion("HANDLE_TIMES not in", values, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesBetween(Integer value1, Integer value2) {
            addCriterion("HANDLE_TIMES between", value1, value2, "handleTimes");
            return (Criteria) this;
        }

        public Criteria andHandleTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("HANDLE_TIMES not between", value1, value2, "handleTimes");
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