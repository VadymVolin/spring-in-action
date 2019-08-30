package spitter.data;

import javax.persistence.*;

@Entity
@Table(name="spitter")
public class Spitter {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String fullName;

    public Spitter() {

    }

    public Spitter( String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public Spitter(int id, String userName, String password, String fullName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", username=" + userName + ", password=" + password + ", fullname=" + fullName + "]";
    }
}
