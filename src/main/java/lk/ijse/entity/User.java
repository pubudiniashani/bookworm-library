package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToOne
    private Branch branch;
    @ManyToMany
    @JoinTable(
            name = "Transaction",
            joinColumns =  @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "bookId")
    )


    private List<Book> bookList;

    public User() {

    }

    public User(int id, String name, String email, String password, Branch branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.branch = branch;
    }

    public User(int id, String name, String email, String password, Branch branch, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.branch = branch;
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
