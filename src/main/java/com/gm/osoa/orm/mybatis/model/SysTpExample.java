package com.gm.osoa.orm.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class SysTpExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public SysTpExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_tp
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_tp
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

		public Criteria andTpIdIsNull() {
			addCriterion("tp_id is null");
			return (Criteria) this;
		}

		public Criteria andTpIdIsNotNull() {
			addCriterion("tp_id is not null");
			return (Criteria) this;
		}

		public Criteria andTpIdEqualTo(String value) {
			addCriterion("tp_id =", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdNotEqualTo(String value) {
			addCriterion("tp_id <>", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdGreaterThan(String value) {
			addCriterion("tp_id >", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdGreaterThanOrEqualTo(String value) {
			addCriterion("tp_id >=", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdLessThan(String value) {
			addCriterion("tp_id <", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdLessThanOrEqualTo(String value) {
			addCriterion("tp_id <=", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdLike(String value) {
			addCriterion("tp_id like", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdNotLike(String value) {
			addCriterion("tp_id not like", value, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdIn(List<String> values) {
			addCriterion("tp_id in", values, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdNotIn(List<String> values) {
			addCriterion("tp_id not in", values, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdBetween(String value1, String value2) {
			addCriterion("tp_id between", value1, value2, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpIdNotBetween(String value1, String value2) {
			addCriterion("tp_id not between", value1, value2, "tpId");
			return (Criteria) this;
		}

		public Criteria andTpCodeIsNull() {
			addCriterion("tp_code is null");
			return (Criteria) this;
		}

		public Criteria andTpCodeIsNotNull() {
			addCriterion("tp_code is not null");
			return (Criteria) this;
		}

		public Criteria andTpCodeEqualTo(String value) {
			addCriterion("tp_code =", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeNotEqualTo(String value) {
			addCriterion("tp_code <>", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeGreaterThan(String value) {
			addCriterion("tp_code >", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeGreaterThanOrEqualTo(String value) {
			addCriterion("tp_code >=", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeLessThan(String value) {
			addCriterion("tp_code <", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeLessThanOrEqualTo(String value) {
			addCriterion("tp_code <=", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeLike(String value) {
			addCriterion("tp_code like", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeNotLike(String value) {
			addCriterion("tp_code not like", value, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeIn(List<String> values) {
			addCriterion("tp_code in", values, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeNotIn(List<String> values) {
			addCriterion("tp_code not in", values, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeBetween(String value1, String value2) {
			addCriterion("tp_code between", value1, value2, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpCodeNotBetween(String value1, String value2) {
			addCriterion("tp_code not between", value1, value2, "tpCode");
			return (Criteria) this;
		}

		public Criteria andTpNameIsNull() {
			addCriterion("tp_name is null");
			return (Criteria) this;
		}

		public Criteria andTpNameIsNotNull() {
			addCriterion("tp_name is not null");
			return (Criteria) this;
		}

		public Criteria andTpNameEqualTo(String value) {
			addCriterion("tp_name =", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameNotEqualTo(String value) {
			addCriterion("tp_name <>", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameGreaterThan(String value) {
			addCriterion("tp_name >", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameGreaterThanOrEqualTo(String value) {
			addCriterion("tp_name >=", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameLessThan(String value) {
			addCriterion("tp_name <", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameLessThanOrEqualTo(String value) {
			addCriterion("tp_name <=", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameLike(String value) {
			addCriterion("tp_name like", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameNotLike(String value) {
			addCriterion("tp_name not like", value, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameIn(List<String> values) {
			addCriterion("tp_name in", values, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameNotIn(List<String> values) {
			addCriterion("tp_name not in", values, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameBetween(String value1, String value2) {
			addCriterion("tp_name between", value1, value2, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpNameNotBetween(String value1, String value2) {
			addCriterion("tp_name not between", value1, value2, "tpName");
			return (Criteria) this;
		}

		public Criteria andTpTypeIsNull() {
			addCriterion("tp_type is null");
			return (Criteria) this;
		}

		public Criteria andTpTypeIsNotNull() {
			addCriterion("tp_type is not null");
			return (Criteria) this;
		}

		public Criteria andTpTypeEqualTo(String value) {
			addCriterion("tp_type =", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeNotEqualTo(String value) {
			addCriterion("tp_type <>", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeGreaterThan(String value) {
			addCriterion("tp_type >", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeGreaterThanOrEqualTo(String value) {
			addCriterion("tp_type >=", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeLessThan(String value) {
			addCriterion("tp_type <", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeLessThanOrEqualTo(String value) {
			addCriterion("tp_type <=", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeLike(String value) {
			addCriterion("tp_type like", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeNotLike(String value) {
			addCriterion("tp_type not like", value, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeIn(List<String> values) {
			addCriterion("tp_type in", values, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeNotIn(List<String> values) {
			addCriterion("tp_type not in", values, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeBetween(String value1, String value2) {
			addCriterion("tp_type between", value1, value2, "tpType");
			return (Criteria) this;
		}

		public Criteria andTpTypeNotBetween(String value1, String value2) {
			addCriterion("tp_type not between", value1, value2, "tpType");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_tp
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
     * This class corresponds to the database table sys_tp
     *
     * @mbggenerated do_not_delete_during_merge Tue Sep 03 10:20:20 CST 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}