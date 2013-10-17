package com.gm.osoa.orm.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class DeptExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public DeptExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andDeptIdIsNull() {
			addCriterion("dept_id is null");
			return (Criteria) this;
		}

		public Criteria andDeptIdIsNotNull() {
			addCriterion("dept_id is not null");
			return (Criteria) this;
		}

		public Criteria andDeptIdEqualTo(String value) {
			addCriterion("dept_id =", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotEqualTo(String value) {
			addCriterion("dept_id <>", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThan(String value) {
			addCriterion("dept_id >", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
			addCriterion("dept_id >=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThan(String value) {
			addCriterion("dept_id <", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThanOrEqualTo(String value) {
			addCriterion("dept_id <=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLike(String value) {
			addCriterion("dept_id like", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotLike(String value) {
			addCriterion("dept_id not like", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdIn(List<String> values) {
			addCriterion("dept_id in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotIn(List<String> values) {
			addCriterion("dept_id not in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdBetween(String value1, String value2) {
			addCriterion("dept_id between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotBetween(String value1, String value2) {
			addCriterion("dept_id not between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNull() {
			addCriterion("dept_no is null");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNotNull() {
			addCriterion("dept_no is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNoEqualTo(String value) {
			addCriterion("dept_no =", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotEqualTo(String value) {
			addCriterion("dept_no <>", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThan(String value) {
			addCriterion("dept_no >", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThanOrEqualTo(String value) {
			addCriterion("dept_no >=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThan(String value) {
			addCriterion("dept_no <", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThanOrEqualTo(String value) {
			addCriterion("dept_no <=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLike(String value) {
			addCriterion("dept_no like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotLike(String value) {
			addCriterion("dept_no not like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoIn(List<String> values) {
			addCriterion("dept_no in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotIn(List<String> values) {
			addCriterion("dept_no not in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoBetween(String value1, String value2) {
			addCriterion("dept_no between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotBetween(String value1, String value2) {
			addCriterion("dept_no not between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNull() {
			addCriterion("dept_name is null");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNotNull() {
			addCriterion("dept_name is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNameEqualTo(String value) {
			addCriterion("dept_name =", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotEqualTo(String value) {
			addCriterion("dept_name <>", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThan(String value) {
			addCriterion("dept_name >", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("dept_name >=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThan(String value) {
			addCriterion("dept_name <", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThanOrEqualTo(String value) {
			addCriterion("dept_name <=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLike(String value) {
			addCriterion("dept_name like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotLike(String value) {
			addCriterion("dept_name not like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameIn(List<String> values) {
			addCriterion("dept_name in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotIn(List<String> values) {
			addCriterion("dept_name not in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameBetween(String value1, String value2) {
			addCriterion("dept_name between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotBetween(String value1, String value2) {
			addCriterion("dept_name not between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptTelIsNull() {
			addCriterion("dept_tel is null");
			return (Criteria) this;
		}

		public Criteria andDeptTelIsNotNull() {
			addCriterion("dept_tel is not null");
			return (Criteria) this;
		}

		public Criteria andDeptTelEqualTo(String value) {
			addCriterion("dept_tel =", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelNotEqualTo(String value) {
			addCriterion("dept_tel <>", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelGreaterThan(String value) {
			addCriterion("dept_tel >", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelGreaterThanOrEqualTo(String value) {
			addCriterion("dept_tel >=", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelLessThan(String value) {
			addCriterion("dept_tel <", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelLessThanOrEqualTo(String value) {
			addCriterion("dept_tel <=", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelLike(String value) {
			addCriterion("dept_tel like", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelNotLike(String value) {
			addCriterion("dept_tel not like", value, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelIn(List<String> values) {
			addCriterion("dept_tel in", values, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelNotIn(List<String> values) {
			addCriterion("dept_tel not in", values, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelBetween(String value1, String value2) {
			addCriterion("dept_tel between", value1, value2, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptTelNotBetween(String value1, String value2) {
			addCriterion("dept_tel not between", value1, value2, "deptTel");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanIsNull() {
			addCriterion("dept_lnkman is null");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanIsNotNull() {
			addCriterion("dept_lnkman is not null");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanEqualTo(String value) {
			addCriterion("dept_lnkman =", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanNotEqualTo(String value) {
			addCriterion("dept_lnkman <>", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanGreaterThan(String value) {
			addCriterion("dept_lnkman >", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanGreaterThanOrEqualTo(String value) {
			addCriterion("dept_lnkman >=", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanLessThan(String value) {
			addCriterion("dept_lnkman <", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanLessThanOrEqualTo(String value) {
			addCriterion("dept_lnkman <=", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanLike(String value) {
			addCriterion("dept_lnkman like", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanNotLike(String value) {
			addCriterion("dept_lnkman not like", value, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanIn(List<String> values) {
			addCriterion("dept_lnkman in", values, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanNotIn(List<String> values) {
			addCriterion("dept_lnkman not in", values, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanBetween(String value1, String value2) {
			addCriterion("dept_lnkman between", value1, value2, "deptLnkman");
			return (Criteria) this;
		}

		public Criteria andDeptLnkmanNotBetween(String value1, String value2) {
			addCriterion("dept_lnkman not between", value1, value2,
					"deptLnkman");
			return (Criteria) this;
		}

		public Criteria andSupIdIsNull() {
			addCriterion("sup_id is null");
			return (Criteria) this;
		}

		public Criteria andSupIdIsNotNull() {
			addCriterion("sup_id is not null");
			return (Criteria) this;
		}

		public Criteria andSupIdEqualTo(String value) {
			addCriterion("sup_id =", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdNotEqualTo(String value) {
			addCriterion("sup_id <>", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdGreaterThan(String value) {
			addCriterion("sup_id >", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdGreaterThanOrEqualTo(String value) {
			addCriterion("sup_id >=", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdLessThan(String value) {
			addCriterion("sup_id <", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdLessThanOrEqualTo(String value) {
			addCriterion("sup_id <=", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdLike(String value) {
			addCriterion("sup_id like", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdNotLike(String value) {
			addCriterion("sup_id not like", value, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdIn(List<String> values) {
			addCriterion("sup_id in", values, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdNotIn(List<String> values) {
			addCriterion("sup_id not in", values, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdBetween(String value1, String value2) {
			addCriterion("sup_id between", value1, value2, "supId");
			return (Criteria) this;
		}

		public Criteria andSupIdNotBetween(String value1, String value2) {
			addCriterion("sup_id not between", value1, value2, "supId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table dept
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dept
     *
     * @mbggenerated do_not_delete_during_merge Tue Sep 03 10:20:20 CST 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}