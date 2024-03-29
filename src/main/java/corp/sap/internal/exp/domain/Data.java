package corp.sap.internal.exp.domain;

import java.io.Serializable;

public class Data implements Serializable {

    private static final long serialVersionUID = -3749473825147441328L;
    private Integer id;
    private String name;
    private Integer code;

    public Data() {
    }

    public Data(Integer id, String name, Integer code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
