package pojos;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
/*
This class describes Permissions entity
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Permissions implements Serializable {
    private static final long serialVersionUID = 5L;
    public Permissions(){
    }
    @Id
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "role"))
    @GeneratedValue (generator = "gen")
    private int roleId;

    @Column (columnDefinition = "BIT")
    private boolean addNews;
    @Column (columnDefinition = "BIT")
    private boolean deleteNews;
    @Column (columnDefinition = "BIT")
    private boolean updateNews;
    @Column (columnDefinition = "BIT")
    private boolean readNews;

    @OneToOne
    @JoinColumn (name = "role")
    private Roles role;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isAddNews() {
        return addNews;
    }

    public void setAddNews(boolean addNews) {
        this.addNews = addNews;
    }

    public boolean isDeleteNews() {
        return deleteNews;
    }

    public void setDeleteNews(boolean deleteNews) {
        this.deleteNews = deleteNews;
    }

    public boolean isUpdateNews() {
        return updateNews;
    }

    public void setUpdateNews(boolean updateNews) {
        this.updateNews = updateNews;
    }

    public boolean isReadNews() {
        return readNews;
    }

    public void setReadNews(boolean readNews) {
        this.readNews = readNews;
    }


    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Permissions) {
            Permissions temp = (Permissions) obj;
            if (roleId == temp.roleId
                    && addNews == temp.addNews
                    && deleteNews == temp.deleteNews
                    && updateNews == temp.updateNews
                    && readNews == temp.readNews)
                return true;
            else
                return false;
        } else
            return false;
    }
    @Override
    public int hashCode() {
        String s = roleId + "";
        return s.hashCode();
    }



}
