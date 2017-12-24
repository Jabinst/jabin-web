package com.jabin.domain.base;

import java.util.ArrayList;
import java.util.List;

public class SeedTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeedTestExample() {
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

        public Criteria andVarcharTestIsNull() {
            addCriterion("varchar_test is null");
            return (Criteria) this;
        }

        public Criteria andVarcharTestIsNotNull() {
            addCriterion("varchar_test is not null");
            return (Criteria) this;
        }

        public Criteria andVarcharTestEqualTo(String value) {
            addCriterion("varchar_test =", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestNotEqualTo(String value) {
            addCriterion("varchar_test <>", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestGreaterThan(String value) {
            addCriterion("varchar_test >", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestGreaterThanOrEqualTo(String value) {
            addCriterion("varchar_test >=", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestLessThan(String value) {
            addCriterion("varchar_test <", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestLessThanOrEqualTo(String value) {
            addCriterion("varchar_test <=", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestLike(String value) {
            addCriterion("varchar_test like", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestNotLike(String value) {
            addCriterion("varchar_test not like", value, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestIn(List<String> values) {
            addCriterion("varchar_test in", values, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestNotIn(List<String> values) {
            addCriterion("varchar_test not in", values, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestBetween(String value1, String value2) {
            addCriterion("varchar_test between", value1, value2, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestNotBetween(String value1, String value2) {
            addCriterion("varchar_test not between", value1, value2, "varcharTest");
            return (Criteria) this;
        }

        public Criteria andIntTestIsNull() {
            addCriterion("int_test is null");
            return (Criteria) this;
        }

        public Criteria andIntTestIsNotNull() {
            addCriterion("int_test is not null");
            return (Criteria) this;
        }

        public Criteria andIntTestEqualTo(Integer value) {
            addCriterion("int_test =", value, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestNotEqualTo(Integer value) {
            addCriterion("int_test <>", value, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestGreaterThan(Integer value) {
            addCriterion("int_test >", value, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_test >=", value, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestLessThan(Integer value) {
            addCriterion("int_test <", value, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestLessThanOrEqualTo(Integer value) {
            addCriterion("int_test <=", value, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestIn(List<Integer> values) {
            addCriterion("int_test in", values, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestNotIn(List<Integer> values) {
            addCriterion("int_test not in", values, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestBetween(Integer value1, Integer value2) {
            addCriterion("int_test between", value1, value2, "intTest");
            return (Criteria) this;
        }

        public Criteria andIntTestNotBetween(Integer value1, Integer value2) {
            addCriterion("int_test not between", value1, value2, "intTest");
            return (Criteria) this;
        }

        public Criteria andCharTestIsNull() {
            addCriterion("char_test is null");
            return (Criteria) this;
        }

        public Criteria andCharTestIsNotNull() {
            addCriterion("char_test is not null");
            return (Criteria) this;
        }

        public Criteria andCharTestEqualTo(String value) {
            addCriterion("char_test =", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotEqualTo(String value) {
            addCriterion("char_test <>", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestGreaterThan(String value) {
            addCriterion("char_test >", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestGreaterThanOrEqualTo(String value) {
            addCriterion("char_test >=", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestLessThan(String value) {
            addCriterion("char_test <", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestLessThanOrEqualTo(String value) {
            addCriterion("char_test <=", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestLike(String value) {
            addCriterion("char_test like", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotLike(String value) {
            addCriterion("char_test not like", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestIn(List<String> values) {
            addCriterion("char_test in", values, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotIn(List<String> values) {
            addCriterion("char_test not in", values, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestBetween(String value1, String value2) {
            addCriterion("char_test between", value1, value2, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotBetween(String value1, String value2) {
            addCriterion("char_test not between", value1, value2, "charTest");
            return (Criteria) this;
        }

        public Criteria andVarcharTestLikeInsensitive(String value) {
            addCriterion("upper(varchar_test) like", value.toUpperCase(), "varcharTest");
            return (Criteria) this;
        }

        public Criteria andCharTestLikeInsensitive(String value) {
            addCriterion("upper(char_test) like", value.toUpperCase(), "charTest");
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