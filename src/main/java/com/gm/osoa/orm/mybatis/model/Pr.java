package com.gm.osoa.orm.mybatis.model;

public class Pr {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr.pr_id
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    private String prId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr.roleid
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    private String roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pr.pri_id
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    private String priId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr.pr_id
     *
     * @return the value of pr.pr_id
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    public String getPrId() {
        return prId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr.pr_id
     *
     * @param prId the value for pr.pr_id
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    public void setPrId(String prId) {
        this.prId = prId == null ? null : prId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr.roleid
     *
     * @return the value of pr.roleid
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr.roleid
     *
     * @param roleid the value for pr.roleid
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pr.pri_id
     *
     * @return the value of pr.pri_id
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    public String getPriId() {
        return priId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pr.pri_id
     *
     * @param priId the value for pr.pri_id
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    public void setPriId(String priId) {
        this.priId = priId == null ? null : priId.trim();
    }
}