package entity;

import javax.persistence.*;

@Entity
@Table(name = "REFERENCE_JENERAL", schema = "APP", catalog = "")
@NamedQuery(name = "ReferenceJeneral.getAll", query = "SELECT u from ReferenceJeneral u")
public class ReferenceJeneral {
    private long id;
    private Integer idFaset;
    private Integer idPfaset;
    private Integer num;
    private String name;
    private String value;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ID_FASET")
    public Integer getIdFaset() {
        return idFaset;
    }

    public void setIdFaset(Integer idFaset) {
        this.idFaset = idFaset;
    }

    @Basic
    @Column(name = "ID_PFASET")
    public Integer getIdPfaset() {
        return idPfaset;
    }

    public void setIdPfaset(Integer idPfaset) {
        this.idPfaset = idPfaset;
    }

    @Basic
    @Column(name = "NUM")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReferenceJeneral that = (ReferenceJeneral) o;

        if (id != that.id) return false;
        if (idFaset != null ? !idFaset.equals(that.idFaset) : that.idFaset != null) return false;
        if (idPfaset != null ? !idPfaset.equals(that.idPfaset) : that.idPfaset != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (idFaset != null ? idFaset.hashCode() : 0);
        result = 31 * result + (idPfaset != null ? idPfaset.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
