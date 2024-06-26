package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion Cabinet Médical");

        // Interface "Fiche Patient"
        VBox fichePatientBox = createFichePatientInterface();

        // Interface "Rendez Vous"
        VBox rendezVousBox = createRendezVousInterface();

        // Conteneur pour les deux interfaces avec "Gestion Cabinet Medical" en titre global
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        Label titleLabel = new Label("Gestion Cabinet Médical");
        titleLabel.setFont(Font.font("Arial", 36)); // Changement de la taille de la police
        titleLabel.setTextFill(Color.BLUE);
        root.setTop(titleLabel);

        VBox contentBox = new VBox(20);
        contentBox.getChildren().addAll(fichePatientBox, rendezVousBox);
        root.setCenter(contentBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Crée l'interface pour la fiche patient
    private VBox createFichePatientInterface() {
        VBox fichePatientBox = new VBox(20);
        fichePatientBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        fichePatientBox.setPadding(new Insets(20));

        Label titleLabel = new Label("Fiche Patient");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setTextFill(Color.BLUE);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();
        gridPane.addRow(0, nomLabel, nomField);

        Label prenomLabel = new Label("Prénom:");
        TextField prenomField = new TextField();
        gridPane.addRow(1, prenomLabel, prenomField);
        
        Label dateNaissanceLabel = new Label("Date de naissance:");
        DatePicker dateNaissancePicker = new DatePicker();
        gridPane.addRow(2, dateNaissanceLabel, dateNaissancePicker);

        Label telLabel = new Label("Téléphone:");
        TextField telField = new TextField();
        gridPane.addRow(3, telLabel, telField);

        Label adresseLabel = new Label("Adresse:");
        TextField adresseField = new TextField();
        gridPane.addRow(4, adresseLabel, adresseField);

        Label pathologieLabel = new Label("Pathologie:");
        TextField pathologieField = new TextField();
        gridPane.addRow(5, pathologieLabel, pathologieField);

        Label traitementLabel = new Label("Traitement actuel:");
        TextField traitementField = new TextField();
        gridPane.addRow(6, traitementLabel, traitementField);
        
        Label poidsLabel = new Label("Poids:");
        TextField poidsField = new TextField();
        gridPane.addRow(7, poidsLabel, poidsField);

        Label tailleLabel = new Label("Taille:");
        TextField tailleField = new TextField();
        gridPane.addRow(8, tailleLabel, tailleField);

        Label allergiesLabel = new Label("Allergies:");
        TextField allergiesField = new TextField();
        gridPane.addRow(9, allergiesLabel, allergiesField);
        
        Label chirurgiesLabel = new Label("Chirurgies:");
        TextField chirurgiesField = new TextField();
        gridPane.addRow(10, chirurgiesLabel, chirurgiesField);


        Button sauvegarderButton = new Button("Sauvegarder");
        sauvegarderButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        sauvegarderButton.setOnAction(e -> {
            // Action pour sauvegarder les informations du patient
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String telephone = telField.getText();
            String adresse = adresseField.getText();
            String pathologie = pathologieField.getText();
            String traitement = traitementField.getText();
            sauvegarderFichePatient(nom, prenom, telephone, adresse, pathologie, traitement);
        });

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(sauvegarderButton);

        fichePatientBox.getChildren().addAll(titleLabel, gridPane, buttonBox);

        return fichePatientBox;
    }

    // Méthode pour sauvegarder les informations du patient
    private void sauvegarderFichePatient(String nom, String prenom, String telephone, String adresse, String pathologie, String traitement) {
        // Vous pouvez implémenter ici la logique de sauvegarde dans votre application
        System.out.println("Fiche Patient Sauvegardée:");
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Téléphone: " + telephone);
        System.out.println("Adresse: " + adresse);
        System.out.println("Pathologie: " + pathologie);
        System.out.println("Traitement actuel: " + traitement);
    }

    // Crée l'interface pour prendre un rendez-vous
    private VBox createRendezVousInterface() {
        VBox rendezVousBox = new VBox(20);
        rendezVousBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        rendezVousBox.setPadding(new Insets(20));

        Label titleLabel = new Label("Prendre un rendez-vous");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setTextFill(Color.BLUE);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();
        gridPane.addRow(0, nomLabel, nomField);

        Label prenomLabel = new Label("Prénom:");
        TextField prenomField = new TextField();
        gridPane.addRow(1, prenomLabel, prenomField);

        Label telLabel = new Label("Téléphone:");
        TextField telField = new TextField();
        gridPane.addRow(2, telLabel, telField);

        Label dateLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();
        gridPane.addRow(3, dateLabel, datePicker);

        Label heureLabel = new Label("Heure:");
        TextField heureField = new TextField();
        gridPane.addRow(4, heureLabel, heureField);

        Button prendreRdvBtn = new Button("Prendre RDV");
        prendreRdvBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        gridPane.addRow(5, prendreRdvBtn);

        rendezVousBox.getChildren().addAll(titleLabel, gridPane);

        // Action pour prendre un rendez-vous
        prendreRdvBtn.setOnAction(e -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String telephone = telField.getText();
            String date = datePicker.getValue().toString();
            String heure = heureField.getText();
            // Appeler la méthode prendreRendezVous de votre classe CabinetMedical ici
            // cabinet.prendreRendezVous(date, heure, patient);
            System.out.println("Rendez-vous pris pour le " + date + " à " + heure + " avec " + nom + " " + prenom + " (" + telephone + ")");
        });

        return rendezVousBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

