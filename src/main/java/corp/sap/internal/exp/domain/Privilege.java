package corp.sap.internal.exp.domain;

import java.io.Serializable;

public class Privilege implements Serializable {

    private static final long serialVersionUID = -3405368204674664773L;

    private Integer privilegeId;
    private String name;
    private String privilegeCode;

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}