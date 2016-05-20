package com.ilimi.dac.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.ilimi.dac.BaseDataAccessEntity;

@Entity
@Table(name = "AUDIT_HISTORY")
public class AuditHistoryEntity extends BaseDataAccessEntity {


	private static final long serialVersionUID = -4329702572102109449L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "AUDIT_HISTORY_ID_SEQ")
    @SequenceGenerator(name = "AUDIT_HISTORY_ID_SEQ", sequenceName = "AUDIT_HISTORY_ID_SEQ")
    @Column(name = "SMAH_PK_ID", length = 11)
    private Integer id;

    @Column(name = "OBJECT_ID")
    private String objectId;

    @Column(name = "OBJECT_TYPE")
    private String objectType;

    @Column(name = "LOG_RECORD")
    @Type(type="text")
    private String logRecord;
    
    @Column(name = "GRAPH_ID")
    private String graphId;
    
    @Column(name = "USER_ID")
    private String userId;
    
    @Column(name = "REQUEST_ID")
    private String requestId;
    
    @Column(name = "OPEARATION")
    private String operation;
    
    @Type(type="date")
    @Column(name = "CREATED_ON", nullable = false, updatable=false)
    private Date createdOn;
    
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getLogRecord() {
		return logRecord;
	}

	public void setLogRecord(String logRecord) {
		this.logRecord = logRecord;
	}

	public String getGraphId() {
		return graphId;
	}

	public void setGraphId(String graphId) {
		this.graphId = graphId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Date getCreated() {
		return createdOn;
	}

	public void setCreated(Date createdOn) {
		this.createdOn = createdOn;
	}

}
