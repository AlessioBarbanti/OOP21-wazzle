package wazzle.view.controller;

import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import wazzle.controller.common.WazzleController;
import wazzle.controller.common.WazzleControllerImpl;
import wazzle.view.SceneSwitcher;

public final class SettingsView {

	@FXML
	private VBox mainSettingWindow;

	@FXML
	private Slider gridDimensionSlider;

	@FXML
	private VBox mainSettingsWrapper;

	@FXML
	private ComboBox<String> difficultySelectorCBox;

	@FXML
	private Label difficultySelectorLabel;

	@FXML
	private Label gridDimensionLabel;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	private DoubleProperty visualUnit;
	private final Stage stage;
	private final WazzleController wazzleController;

	public SettingsView(final Stage stage) {
		this.stage = stage;
		this.visualUnit = new SimpleDoubleProperty();
		this.visualUnit.bind(Bindings.min(stage.heightProperty().multiply(0.05), stage.widthProperty().multiply(0.05)));
		this.wazzleController = (WazzleControllerImpl) stage.getUserData();
	}

	public void initialize() {
		this.setGraphic();
		this.wazzleController.getSettings().getAllDifficulties().keySet()
				.forEach(e -> difficultySelectorCBox.getItems().add(e));

		this.difficultySelectorCBox.getSelectionModel().select(this.wazzleController.getSettings().getCurrentDifficultyName());
		this.gridDimensionSlider.setValue(this.wazzleController.getSettings().getCurrentGridShape());
	}

	private void setGraphic() {

		final ObservableValue<String> fontSize = Bindings.concat("-fx-font-size: ", visualUnit.asString(), ";");
		final ObservableValue<String> cbBoxItemFont = Bindings.concat("-fx-font-size: ", visualUnit.multiply(0.7).asString(), ";");
		final ObservableValue<String> paddingValue = Bindings.concat("-fx-padding: ",
				visualUnit.multiply(0.5).asString(), ";");

		this.difficultySelectorCBox.styleProperty().bind(cbBoxItemFont);
		this.difficultySelectorCBox.getStyleClass().add("longIncave");
		this.gridDimensionSlider.maxWidthProperty().bind(visualUnit.multiply(10));
		this.mainSettingWindow.getStyleClass().add("letters");
		this.mainSettingWindow.styleProperty().bind(paddingValue);
		this.mainSettingWindow.getChildren().forEach(e -> e.styleProperty().bind(paddingValue));
		this.mainSettingsWrapper.spacingProperty().bind(visualUnit);

		this.difficultySelectorLabel.styleProperty().bind(fontSize);
		this.gridDimensionLabel.styleProperty().bind(fontSize);
		this.difficultySelectorCBox.maxWidthProperty().bind(gridDimensionSlider.widthProperty());
		this.okButton.styleProperty().bind(fontSize);
		this.cancelButton.styleProperty().bind(fontSize);
	}

	public void goToScene(final ActionEvent event) throws IOException {
		final Node node = (Node) event.getSource();

		if (node.getId().equals("okButton")) {
			final var sliderValue = (int) this.gridDimensionSlider.getValue();
			this.wazzleController.getSettingsController().updateSettings(
					this.wazzleController.getSettingsController().getAllDifficulties().get(difficultySelectorCBox.getValue()).get(sliderValue),
					sliderValue);
			this.wazzleController.saveSettings();
		}
		this.stage.setUserData(this.wazzleController);
		SceneSwitcher.<MainMenuView>switchScene(event, new MainMenuView(this.stage), "layouts/mainMenu.fxml");
	}

}