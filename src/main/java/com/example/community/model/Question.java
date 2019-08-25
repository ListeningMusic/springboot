package com.example.community.model;

public class Question {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.id
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.title
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.create_time
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.modified_time
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private Long modifiedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.creator_id
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private Long creatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.comment_number
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private Integer commentNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.like_number
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private Integer likeNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.tag
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.view_count
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.description
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.id
     *
     * @return the value of question.id
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.id
     *
     * @param id the value for question.id
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.title
     *
     * @return the value of question.title
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.title
     *
     * @param title the value for question.title
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.create_time
     *
     * @return the value of question.create_time
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.create_time
     *
     * @param createTime the value for question.create_time
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.modified_time
     *
     * @return the value of question.modified_time
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public Long getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.modified_time
     *
     * @param modifiedTime the value for question.modified_time
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setModifiedTime(Long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.creator_id
     *
     * @return the value of question.creator_id
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.creator_id
     *
     * @param creatorId the value for question.creator_id
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.comment_number
     *
     * @return the value of question.comment_number
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public Integer getCommentNumber() {
        return commentNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.comment_number
     *
     * @param commentNumber the value for question.comment_number
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.like_number
     *
     * @return the value of question.like_number
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public Integer getLikeNumber() {
        return likeNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.like_number
     *
     * @param likeNumber the value for question.like_number
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.tag
     *
     * @return the value of question.tag
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.tag
     *
     * @param tag the value for question.tag
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.view_count
     *
     * @return the value of question.view_count
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.view_count
     *
     * @param viewCount the value for question.view_count
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.description
     *
     * @return the value of question.description
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.description
     *
     * @param description the value for question.description
     *
     * @mbg.generated Thu Aug 22 15:42:32 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}