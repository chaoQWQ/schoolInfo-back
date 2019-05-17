package com.zc.schoolinfo.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VolunteerActivity {
    private Integer id;

    private String title;

    private String address;

    private String serviceType;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date recruitStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date recruitEndTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    private Integer joinNumbers;

    private Integer recruitNumbers;

    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String coverImage;

    private String author;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titile) {
        this.title = titile == null ? null : titile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public Date getRecruitStartTime() {
        return recruitStartTime;
    }

    public void setRecruitStartTime(Date recruitStartTime) {
        this.recruitStartTime = recruitStartTime;
    }

    public Date getRecruitEndTime() {
        return recruitEndTime;
    }

    public void setRecruitEndTime(Date recruitEndTime) {
        this.recruitEndTime = recruitEndTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getJoinNumbers() {
        return joinNumbers;
    }

    public void setJoinNumbers(Integer joinNumbers) {
        this.joinNumbers = joinNumbers;
    }

    public Integer getRecruitNumbers() {
        return recruitNumbers;
    }

    public void setRecruitNumbers(Integer recruitNumbers) {
        this.recruitNumbers = recruitNumbers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }
}