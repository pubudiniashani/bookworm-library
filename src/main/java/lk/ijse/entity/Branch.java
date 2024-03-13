package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lk.ijse.controller.LibraryFormController;

import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue
    private int branchId;
    private String name;
    private String address;
    private String contact;
    @OneToMany(mappedBy = "branch")
    private List<User> userList;

    public Branch() {
    }

    public Branch(int branchId, String name, String address, String contact, List<User> userList) {
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.userList = userList;
    }
}
