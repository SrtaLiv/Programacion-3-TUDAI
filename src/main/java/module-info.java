module org.example.programacion3javatudai {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.programacion3javatudai to javafx.fxml;
    exports org.example.programacion3javatudai;
}