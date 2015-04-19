package net.eutkin.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ts")
public class TS {
    @Id
    @Column(name = "ts_id")
    @NotNull
    private Integer ts_id;

    @Column(name = "ts_name")
    @NotNull
    private String tsName;

    @Column(name = "ts_comment")
    @NotNull
    private String tsComment;

    public Integer getTs_id() {
        return ts_id;
    }

    public void setTs_id(Integer ts_id) {
        this.ts_id = ts_id;
    }

    public String getTsName() {
        return tsName;
    }

    public void setTsName(String tsName) {
        this.tsName = tsName;
    }

    public String getTsComment() {
        return tsComment;
    }

    public void setTsComment(String tsComment) {
        this.tsComment = tsComment;
    }
}
