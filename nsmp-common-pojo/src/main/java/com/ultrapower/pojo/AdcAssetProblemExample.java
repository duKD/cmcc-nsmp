package com.ultrapower.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdcAssetProblemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdcAssetProblemExample() {
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

        public Criteria andPropCodeIsNull() {
            addCriterion("PROP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPropCodeIsNotNull() {
            addCriterion("PROP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPropCodeEqualTo(String value) {
            addCriterion("PROP_CODE =", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeNotEqualTo(String value) {
            addCriterion("PROP_CODE <>", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeGreaterThan(String value) {
            addCriterion("PROP_CODE >", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROP_CODE >=", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeLessThan(String value) {
            addCriterion("PROP_CODE <", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeLessThanOrEqualTo(String value) {
            addCriterion("PROP_CODE <=", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeLike(String value) {
            addCriterion("PROP_CODE like", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeNotLike(String value) {
            addCriterion("PROP_CODE not like", value, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeIn(List<String> values) {
            addCriterion("PROP_CODE in", values, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeNotIn(List<String> values) {
            addCriterion("PROP_CODE not in", values, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeBetween(String value1, String value2) {
            addCriterion("PROP_CODE between", value1, value2, "propCode");
            return (Criteria) this;
        }

        public Criteria andPropCodeNotBetween(String value1, String value2) {
            addCriterion("PROP_CODE not between", value1, value2, "propCode");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIsNull() {
            addCriterion("CURRENT_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIsNotNull() {
            addCriterion("CURRENT_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionEqualTo(String value) {
            addCriterion("CURRENT_VERSION =", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotEqualTo(String value) {
            addCriterion("CURRENT_VERSION <>", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionGreaterThan(String value) {
            addCriterion("CURRENT_VERSION >", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_VERSION >=", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLessThan(String value) {
            addCriterion("CURRENT_VERSION <", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_VERSION <=", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLike(String value) {
            addCriterion("CURRENT_VERSION like", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotLike(String value) {
            addCriterion("CURRENT_VERSION not like", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIn(List<String> values) {
            addCriterion("CURRENT_VERSION in", values, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotIn(List<String> values) {
            addCriterion("CURRENT_VERSION not in", values, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionBetween(String value1, String value2) {
            addCriterion("CURRENT_VERSION between", value1, value2, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotBetween(String value1, String value2) {
            addCriterion("CURRENT_VERSION not between", value1, value2, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionIsNull() {
            addCriterion("PREVIOUS_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionIsNotNull() {
            addCriterion("PREVIOUS_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionEqualTo(String value) {
            addCriterion("PREVIOUS_VERSION =", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionNotEqualTo(String value) {
            addCriterion("PREVIOUS_VERSION <>", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionGreaterThan(String value) {
            addCriterion("PREVIOUS_VERSION >", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionGreaterThanOrEqualTo(String value) {
            addCriterion("PREVIOUS_VERSION >=", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionLessThan(String value) {
            addCriterion("PREVIOUS_VERSION <", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionLessThanOrEqualTo(String value) {
            addCriterion("PREVIOUS_VERSION <=", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionLike(String value) {
            addCriterion("PREVIOUS_VERSION like", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionNotLike(String value) {
            addCriterion("PREVIOUS_VERSION not like", value, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionIn(List<String> values) {
            addCriterion("PREVIOUS_VERSION in", values, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionNotIn(List<String> values) {
            addCriterion("PREVIOUS_VERSION not in", values, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionBetween(String value1, String value2) {
            addCriterion("PREVIOUS_VERSION between", value1, value2, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andPreviousVersionNotBetween(String value1, String value2) {
            addCriterion("PREVIOUS_VERSION not between", value1, value2, "previousVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionIsNull() {
            addCriterion("BASELINE_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionIsNotNull() {
            addCriterion("BASELINE_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionEqualTo(String value) {
            addCriterion("BASELINE_VERSION =", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionNotEqualTo(String value) {
            addCriterion("BASELINE_VERSION <>", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionGreaterThan(String value) {
            addCriterion("BASELINE_VERSION >", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionGreaterThanOrEqualTo(String value) {
            addCriterion("BASELINE_VERSION >=", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionLessThan(String value) {
            addCriterion("BASELINE_VERSION <", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionLessThanOrEqualTo(String value) {
            addCriterion("BASELINE_VERSION <=", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionLike(String value) {
            addCriterion("BASELINE_VERSION like", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionNotLike(String value) {
            addCriterion("BASELINE_VERSION not like", value, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionIn(List<String> values) {
            addCriterion("BASELINE_VERSION in", values, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionNotIn(List<String> values) {
            addCriterion("BASELINE_VERSION not in", values, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionBetween(String value1, String value2) {
            addCriterion("BASELINE_VERSION between", value1, value2, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andBaselineVersionNotBetween(String value1, String value2) {
            addCriterion("BASELINE_VERSION not between", value1, value2, "baselineVersion");
            return (Criteria) this;
        }

        public Criteria andFoundTimeIsNull() {
            addCriterion("FOUND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFoundTimeIsNotNull() {
            addCriterion("FOUND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFoundTimeEqualTo(Date value) {
            addCriterion("FOUND_TIME =", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeNotEqualTo(Date value) {
            addCriterion("FOUND_TIME <>", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeGreaterThan(Date value) {
            addCriterion("FOUND_TIME >", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FOUND_TIME >=", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeLessThan(Date value) {
            addCriterion("FOUND_TIME <", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeLessThanOrEqualTo(Date value) {
            addCriterion("FOUND_TIME <=", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeIn(List<Date> values) {
            addCriterion("FOUND_TIME in", values, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeNotIn(List<Date> values) {
            addCriterion("FOUND_TIME not in", values, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeBetween(Date value1, Date value2) {
            addCriterion("FOUND_TIME between", value1, value2, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeNotBetween(Date value1, Date value2) {
            addCriterion("FOUND_TIME not between", value1, value2, "foundTime");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIsNull() {
            addCriterion("PROBLEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIsNotNull() {
            addCriterion("PROBLEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProblemTypeEqualTo(String value) {
            addCriterion("PROBLEM_TYPE =", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeNotEqualTo(String value) {
            addCriterion("PROBLEM_TYPE <>", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeGreaterThan(String value) {
            addCriterion("PROBLEM_TYPE >", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROBLEM_TYPE >=", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeLessThan(String value) {
            addCriterion("PROBLEM_TYPE <", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeLessThanOrEqualTo(String value) {
            addCriterion("PROBLEM_TYPE <=", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeLike(String value) {
            addCriterion("PROBLEM_TYPE like", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeNotLike(String value) {
            addCriterion("PROBLEM_TYPE not like", value, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIn(List<String> values) {
            addCriterion("PROBLEM_TYPE in", values, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeNotIn(List<String> values) {
            addCriterion("PROBLEM_TYPE not in", values, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeBetween(String value1, String value2) {
            addCriterion("PROBLEM_TYPE between", value1, value2, "problemType");
            return (Criteria) this;
        }

        public Criteria andProblemTypeNotBetween(String value1, String value2) {
            addCriterion("PROBLEM_TYPE not between", value1, value2, "problemType");
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

        public Criteria andProblemStateIsNull() {
            addCriterion("PROBLEM_STATE is null");
            return (Criteria) this;
        }

        public Criteria andProblemStateIsNotNull() {
            addCriterion("PROBLEM_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andProblemStateEqualTo(Short value) {
            addCriterion("PROBLEM_STATE =", value, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateNotEqualTo(Short value) {
            addCriterion("PROBLEM_STATE <>", value, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateGreaterThan(Short value) {
            addCriterion("PROBLEM_STATE >", value, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateGreaterThanOrEqualTo(Short value) {
            addCriterion("PROBLEM_STATE >=", value, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateLessThan(Short value) {
            addCriterion("PROBLEM_STATE <", value, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateLessThanOrEqualTo(Short value) {
            addCriterion("PROBLEM_STATE <=", value, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateIn(List<Short> values) {
            addCriterion("PROBLEM_STATE in", values, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateNotIn(List<Short> values) {
            addCriterion("PROBLEM_STATE not in", values, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateBetween(Short value1, Short value2) {
            addCriterion("PROBLEM_STATE between", value1, value2, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemStateNotBetween(Short value1, Short value2) {
            addCriterion("PROBLEM_STATE not between", value1, value2, "problemState");
            return (Criteria) this;
        }

        public Criteria andProblemDescIsNull() {
            addCriterion("PROBLEM_DESC is null");
            return (Criteria) this;
        }

        public Criteria andProblemDescIsNotNull() {
            addCriterion("PROBLEM_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andProblemDescEqualTo(String value) {
            addCriterion("PROBLEM_DESC =", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescNotEqualTo(String value) {
            addCriterion("PROBLEM_DESC <>", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescGreaterThan(String value) {
            addCriterion("PROBLEM_DESC >", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescGreaterThanOrEqualTo(String value) {
            addCriterion("PROBLEM_DESC >=", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescLessThan(String value) {
            addCriterion("PROBLEM_DESC <", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescLessThanOrEqualTo(String value) {
            addCriterion("PROBLEM_DESC <=", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescLike(String value) {
            addCriterion("PROBLEM_DESC like", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescNotLike(String value) {
            addCriterion("PROBLEM_DESC not like", value, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescIn(List<String> values) {
            addCriterion("PROBLEM_DESC in", values, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescNotIn(List<String> values) {
            addCriterion("PROBLEM_DESC not in", values, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescBetween(String value1, String value2) {
            addCriterion("PROBLEM_DESC between", value1, value2, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemDescNotBetween(String value1, String value2) {
            addCriterion("PROBLEM_DESC not between", value1, value2, "problemDesc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcIsNull() {
            addCriterion("PROBLEM_SRC is null");
            return (Criteria) this;
        }

        public Criteria andProblemSrcIsNotNull() {
            addCriterion("PROBLEM_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSrcEqualTo(String value) {
            addCriterion("PROBLEM_SRC =", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcNotEqualTo(String value) {
            addCriterion("PROBLEM_SRC <>", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcGreaterThan(String value) {
            addCriterion("PROBLEM_SRC >", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcGreaterThanOrEqualTo(String value) {
            addCriterion("PROBLEM_SRC >=", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcLessThan(String value) {
            addCriterion("PROBLEM_SRC <", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcLessThanOrEqualTo(String value) {
            addCriterion("PROBLEM_SRC <=", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcLike(String value) {
            addCriterion("PROBLEM_SRC like", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcNotLike(String value) {
            addCriterion("PROBLEM_SRC not like", value, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcIn(List<String> values) {
            addCriterion("PROBLEM_SRC in", values, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcNotIn(List<String> values) {
            addCriterion("PROBLEM_SRC not in", values, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcBetween(String value1, String value2) {
            addCriterion("PROBLEM_SRC between", value1, value2, "problemSrc");
            return (Criteria) this;
        }

        public Criteria andProblemSrcNotBetween(String value1, String value2) {
            addCriterion("PROBLEM_SRC not between", value1, value2, "problemSrc");
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