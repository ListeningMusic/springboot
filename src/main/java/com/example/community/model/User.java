package com.example.community.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.id
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.name
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.account_id
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.token
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.create_time
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column testdb.modified_time
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    private Long modifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.id
     *
     * @return the value of testdb.id
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.id
     *
     * @param id the value for testdb.id
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.name
     *
     * @return the value of testdb.name
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.name
     *
     * @param name the value for testdb.name
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.account_id
     *
     * @return the value of testdb.account_id
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.account_id
     *
     * @param accountId the value for testdb.account_id
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.token
     *
     * @return the value of testdb.token
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.token
     *
     * @param token the value for testdb.token
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.create_time
     *
     * @return the value of testdb.create_time
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.create_time
     *
     * @param createTime the value for testdb.create_time
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column testdb.modified_time
     *
     * @return the value of testdb.modified_time
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public Long getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column testdb.modified_time
     *
     * @param modifiedTime the value for testdb.modified_time
     *
     * @mbg.generated Thu Aug 15 16:45:34 CST 2019
     */
    public void setModifiedTime(Long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}