package MichaelAsafo_sec005_ex01;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainController implements Initializable {
	ArrayList<String> arr = new ArrayList<String>();                 //list that stores the comboBox course values
	// set variables
    @FXML
    private ComboBox<String> combobox;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField province;

    @FXML
    private TextField city;

    @FXML
    private TextField postalcode;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField email;

    @FXML
    private RadioButton compsci;

    @FXML
    private RadioButton business;

    @FXML
    private ListView<String> combobox_display;

    @FXML
    private Button submit_btn;

    @FXML
    private Label Output;

    @FXML
    private TextArea information;
    
    @FXML
    private CheckBox coop;

    @FXML
    private RadioButton parttime;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton fulltime;
    //List of courses
    ObservableList<String> compsci_= FXCollections.observableArrayList("Data Structures & Algorithms", "Databases", "Linear Algebra", "English","Programming");
    ObservableList<String> business_=FXCollections.observableArrayList("Marketing","Business Management","Accounting","Law","Intro to Macroeconomics");
    
    @FXML
    void submit_btn_clicked(ActionEvent event) {
    	int num = Integer.parseInt(phonenumber.getText());
    	String new_name = "Name: " + name.getText();
    	String new_address= "\nAddress: " + address.getText();
    	String new_province="\nProvince: " + province.getText();
    	String new_city="\nCity: " + city.getText();
    	String new_postalcode="\nPostal Code: "+ postalcode.getText();
    	String new_email="\nEmail: " + email.getText();
    	String total = new_name + new_address + new_province + new_city + new_postalcode + "\n" + String.valueOf(num) + new_email + "\nCourses: ";
    	
    	for (String a:arr) {                                    //adds courses to string
    		total = total + "\n" + a;
    	}
    	
    	if (coop.isSelected()) {                                //select coop
    		total += "\nEnrolled in COOP";
    	}
    	
    	if (fulltime.isSelected()) {                          //selects full-time status
    		total += "\nStatus: Full-time";
    	}
    	
    	if (parttime.isSelected()) {                          //selects part-time status
    		total += "\nStatus: Part-time";
    	}
    	
    	information.setText(total);                           // Entire string posted
    }
    
    public void initialize(URL location, ResourceBundle resources) {
    	//TODO Auto-generated method stub
    
    }
   
    //method to fill comboBox
    public void radioSelection(ActionEvent event) {
    	boolean isSelected = compsci.isSelected();
    	boolean isSelected2= business.isSelected();
    	if (isSelected) {
    	arr.clear();
    	combobox_display.getItems().clear();
    	combobox.setItems(compsci_);
    	}
    	
    	if (isSelected2) {
    		combobox_display.getItems().clear();
    		arr.clear();
    		combobox.setItems(business_);
    	}
    	
    }
    
    //method to get value from combobox and store in list
    public void addListview(ActionEvent event) {
    	if (!arr.contains(combobox.getValue())) {
    	combobox_display.getItems().add(combobox.getValue());
    	arr.add(combobox.getValue());
    	}
    }

}

