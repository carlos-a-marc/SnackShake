
package br.com.snackshake.controller.util;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author Carlos
 */
public class Trasitions {
    public void slideHorizontal(AnchorPane pane){
        TranslateTransition tt = new TranslateTransition(Duration.millis(500), pane);
        tt.setFromX(300);
        tt.setToX(0);
        tt.play();
    }
    
    public void fadeOff(AnchorPane pane){
        FadeTransition ft = new FadeTransition(Duration.millis(300), pane);
        ft.setToValue(0);
        ft.play();
    }
}
