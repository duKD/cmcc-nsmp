package com.ultrapower.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdcAssetProblemDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdcAssetProblemDetailExample() {
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

        public Criteria andPkAssetProblemDetailIsNull() {
            addCriterion("PK_ASSET_PROBLEM_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailIsNotNull() {
            addCriterion("PK_ASSET_PROBLEM_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL =", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailNotEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL <>", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailGreaterThan(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL >", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL >=", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailLessThan(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL <", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailLessThanOrEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL <=", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailLike(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL like", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailNotLike(String value) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL not like", value, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailIn(List<String> values) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL in", values, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailNotIn(List<String> values) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL not in", values, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailBetween(String value1, String value2) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL between", value1, value2, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemDetailNotBetween(String value1, String value2) {
            addCriterion("PK_ASSET_PROBLEM_DETAIL not between", value1, value2, "pkAssetProblemDetail");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemIsNull() {
            addCriterion("PK_ASSET_PROBLEM is null");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemIsNotNull() {
            addCriterion("PK_ASSET_PROBLEM is not null");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM =", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemNotEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM <>", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemGreaterThan(String value) {
            addCriterion("PK_ASSET_PROBLEM >", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM >=", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemLessThan(String value) {
            addCriterion("PK_ASSET_PROBLEM <", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemLessThanOrEqualTo(String value) {
            addCriterion("PK_ASSET_PROBLEM <=", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemLike(String value) {
            addCriterion("PK_ASSET_PROBLEM like", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemNotLike(String value) {
            addCriterion("PK_ASSET_PROBLEM not like", value, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemIn(List<String> values) {
            addCriterion("PK_ASSET_PROBLEM in", values, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemNotIn(List<String> values) {
            addCriterion("PK_ASSET_PROBLEM not in", values, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemBetween(String value1, String value2) {
            addCriterion("PK_ASSET_PROBLEM between", value1, value2, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andPkAssetProblemNotBetween(String value1, String value2) {
            addCriterion("PK_ASSET_PROBLEM not between", value1, value2, "pkAssetProblem");
            return (Criteria) this;
        }

        public Criteria andProblemCodeIsNull() {
            addCriterion("PROBLEM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProblemCodeIsNotNull() {
            addCriterion("PROBLEM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProblemCodeEqualTo(String value) {
            addCriterion("PROBLEM_CODE =", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeNotEqualTo(String value) {
            addCriterion("PROBLEM_CODE <>", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeGreaterThan(String value) {
            addCriterion("PROBLEM_CODE >", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROBLEM_CODE >=", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeLessThan(String value) {
            addCriterion("PROBLEM_CODE <", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeLessThanOrEqualTo(String value) {
            addCriterion("PROBLEM_CODE <=", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeLike(String value) {
            addCriterion("PROBLEM_CODE like", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeNotLike(String value) {
            addCriterion("PROBLEM_CODE not like", value, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeIn(List<String> values) {
            addCriterion("PROBLEM_CODE in", values, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeNotIn(List<String> values) {
            addCriterion("PROBLEM_CODE not in", values, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeBetween(String value1, String value2) {
            addCriterion("PROBLEM_CODE between", value1, value2, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemCodeNotBetween(String value1, String value2) {
            addCriterion("PROBLEM_CODE not between", value1, value2, "problemCode");
            return (Criteria) this;
        }

        public Criteria andProblemContentIsNull() {
            addCriterion("PROBLEM_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andProblemContentIsNotNull() {
            addCriterion("PROBLEM_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andProblemContentEqualTo(String value) {
            addCriterion("PROBLEM_CONTENT =", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotEqualTo(String value) {
            addCriterion("PROBLEM_CONTENT <>", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentGreaterThan(String value) {
            addCriterion("PROBLEM_CONTENT >", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentGreaterThanOrEqualTo(String value) {
            addCriterion("PROBLEM_CONTENT >=", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentLessThan(String value) {
            addCriterion("PROBLEM_CONTENT <", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentLessThanOrEqualTo(String value) {
            addCriterion("PROBLEM_CONTENT <=", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentLike(String value) {
            addCriterion("PROBLEM_CONTENT like", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotLike(String value) {
            addCriterion("PROBLEM_CONTENT not like", value, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentIn(List<String> values) {
            addCriterion("PROBLEM_CONTENT in", values, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotIn(List<String> values) {
            addCriterion("PROBLEM_CONTENT not in", values, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentBetween(String value1, String value2) {
            addCriterion("PROBLEM_CONTENT between", value1, value2, "problemContent");
            return (Criteria) this;
        }

        public Criteria andProblemContentNotBetween(String value1, String value2) {
            addCriterion("PROBLEM_CONTENT not between", value1, value2, "problemContent");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelIsNull() {
            addCriterion("SEVERITY_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelIsNotNull() {
            addCriterion("SEVERITY_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelEqualTo(Integer value) {
            addCriterion("SEVERITY_LEVEL =", value, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelNotEqualTo(Integer value) {
            addCriterion("SEVERITY_LEVEL <>", value, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelGreaterThan(Integer value) {
            addCriterion("SEVERITY_LEVEL >", value, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEVERITY_LEVEL >=", value, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelLessThan(Integer value) {
            addCriterion("SEVERITY_LEVEL <", value, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelLessThanOrEqualTo(Integer value) {
            addCriterion("SEVERITY_LEVEL <=", value, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelIn(List<Integer> values) {
            addCriterion("SEVERITY_LEVEL in", values, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelNotIn(List<Integer> values) {
            addCriterion("SEVERITY_LEVEL not in", values, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelBetween(Integer value1, Integer value2) {
            addCriterion("SEVERITY_LEVEL between", value1, value2, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andSeverityLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("SEVERITY_LEVEL not between", value1, value2, "severityLevel");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordIsNull() {
            addCriterion("PK_COLLECT_RECORD is null");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordIsNotNull() {
            addCriterion("PK_COLLECT_RECORD is not null");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordEqualTo(String value) {
            addCriterion("PK_COLLECT_RECORD =", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordNotEqualTo(String value) {
            addCriterion("PK_COLLECT_RECORD <>", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordGreaterThan(String value) {
            addCriterion("PK_COLLECT_RECORD >", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordGreaterThanOrEqualTo(String value) {
            addCriterion("PK_COLLECT_RECORD >=", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordLessThan(String value) {
            addCriterion("PK_COLLECT_RECORD <", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordLessThanOrEqualTo(String value) {
            addCriterion("PK_COLLECT_RECORD <=", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordLike(String value) {
            addCriterion("PK_COLLECT_RECORD like", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordNotLike(String value) {
            addCriterion("PK_COLLECT_RECORD not like", value, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordIn(List<String> values) {
            addCriterion("PK_COLLECT_RECORD in", values, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordNotIn(List<String> values) {
            addCriterion("PK_COLLECT_RECORD not in", values, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordBetween(String value1, String value2) {
            addCriterion("PK_COLLECT_RECORD between", value1, value2, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkCollectRecordNotBetween(String value1, String value2) {
            addCriterion("PK_COLLECT_RECORD not between", value1, value2, "pkCollectRecord");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineIsNull() {
            addCriterion("PK_PROBLEM_BASELINE is null");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineIsNotNull() {
            addCriterion("PK_PROBLEM_BASELINE is not null");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineEqualTo(String value) {
            addCriterion("PK_PROBLEM_BASELINE =", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineNotEqualTo(String value) {
            addCriterion("PK_PROBLEM_BASELINE <>", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineGreaterThan(String value) {
            addCriterion("PK_PROBLEM_BASELINE >", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineGreaterThanOrEqualTo(String value) {
            addCriterion("PK_PROBLEM_BASELINE >=", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineLessThan(String value) {
            addCriterion("PK_PROBLEM_BASELINE <", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineLessThanOrEqualTo(String value) {
            addCriterion("PK_PROBLEM_BASELINE <=", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineLike(String value) {
            addCriterion("PK_PROBLEM_BASELINE like", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineNotLike(String value) {
            addCriterion("PK_PROBLEM_BASELINE not like", value, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineIn(List<String> values) {
            addCriterion("PK_PROBLEM_BASELINE in", values, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineNotIn(List<String> values) {
            addCriterion("PK_PROBLEM_BASELINE not in", values, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineBetween(String value1, String value2) {
            addCriterion("PK_PROBLEM_BASELINE between", value1, value2, "pkProblemBaseline");
            return (Criteria) this;
        }

        public Criteria andPkProblemBaselineNotBetween(String value1, String value2) {
            addCriterion("PK_PROBLEM_BASELINE not between", value1, value2, "pkProblemBaseline");
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