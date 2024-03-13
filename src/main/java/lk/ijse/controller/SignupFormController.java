package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.impl.AdminBoImpl;
import lk.ijse.dto.AdminDto;

import java.io.IOException;
import java.sql.SQLException;

public class SignupFormController {
    public TextField txtFirstName;
    public TextField txtEmail;
    public TextField txtLastname;
    public TextField txtPassword;
    public AnchorPane root;

    private AdminBo adminBo = new AdminBoImpl();

    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {

        AdminDto adminDto = getData();

        try {
            AdminDto isSaved = adminBo.addAdmin(adminDto);
            if(isSaved != null){
                new Alert(Alert.AlertType.INFORMATION,"saved").show();
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/adminlogin_form.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Admin Form");
                stage.centerOnScreen();

                clearTextFields();
            }
            else{
                new Alert(Alert.AlertType.ERROR, "Not Saved").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private AdminDto getData(){
        AdminDto adminDto = new AdminDto();
        adminDto.setFirstName(txtFirstName.getText());
        adminDto.setLastName(txtLastname.getText());
        adminDto.setEmail(txtEmail.getText());
        adminDto.setPassword(txtPassword.getText());

        System.out.println(txtFirstName);
        System.out.println(txtLastname);
        System.out.println(txtEmail);
        System.out.println(txtPassword);

        return adminDto;
    }

    private void clearTextFields(){
        txtFirstName.setText("");
        txtLastname.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }

    public void btnCreateOnAction(ActionEvent actionEvent) throws IOException {

                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/adminlogin_form.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Admin Form");
                stage.centerOnScreen();


    }
}
