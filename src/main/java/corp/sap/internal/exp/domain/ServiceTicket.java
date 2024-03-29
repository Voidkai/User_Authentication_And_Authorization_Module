package corp.sap.internal.exp.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.sql.Timestamp;

public class ServiceTicket implements Serializable {
    private static final long serialVersionUID = -8277734413593886973L;
    private Integer id;

    @CreatedDate
    private Timestamp updateTime;

    @CreatedBy
    private Integer creator;
    private String content;

    public ServiceTicket() {
    }

    public ServiceTicket(String content) {
        this.content = content;
    }

    public ServiceTicket(Integer id, Timestamp updateTime, Integer creator, String content) {
        this.id = id;
        this.updateTime = updateTime;
        this.creator = creator;
        this.content = content;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }
}
