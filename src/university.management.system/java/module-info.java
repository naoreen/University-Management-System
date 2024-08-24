module org.example.universitymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.universitymanagementsystem to javafx.fxml;
    exports org.example.universitymanagementsystem;
}