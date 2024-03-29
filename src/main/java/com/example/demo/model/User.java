package com.example.demo.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.name
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.token
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.gmt_create
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    private Long gmt_create;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.account_id
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    private String account_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.gmt_modified
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    private Long gmt_modified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.avatarUrl
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    private String avatarUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.name
     *
     * @return the value of users.name
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.name
     *
     * @param name the value for users.name
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.token
     *
     * @return the value of users.token
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.token
     *
     * @param token the value for users.token
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.gmt_create
     *
     * @return the value of users.gmt_create
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public Long getGmt_create() {
        return gmt_create;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.gmt_create
     *
     * @param gmt_create the value for users.gmt_create
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.account_id
     *
     * @return the value of users.account_id
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public String getAccount_id() {
        return account_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.account_id
     *
     * @param account_id the value for users.account_id
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public void setAccount_id(String account_id) {
        this.account_id = account_id == null ? null : account_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.gmt_modified
     *
     * @return the value of users.gmt_modified
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public Long getGmt_modified() {
        return gmt_modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.gmt_modified
     *
     * @param gmt_modified the value for users.gmt_modified
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public void setGmt_modified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.avatarUrl
     *
     * @return the value of users.avatarUrl
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.avatarUrl
     *
     * @param avatarUrl the value for users.avatarUrl
     *
     * @mbg.generated Thu Sep 05 21:37:49 CST 2019
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}