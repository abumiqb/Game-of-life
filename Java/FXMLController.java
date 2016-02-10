package game.of.life;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;


public class FXMLController implements Initializable 
{
    @FXML private Canvas canvas;
    GraphicsContext gc;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
      
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
      
        
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Tegne(graphicsContext);
         
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent event) -> 
        {
            graphicsContext.beginPath();
            graphicsContext.moveTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });
         
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent event) ->
        {
            graphicsContext.lineTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });
 
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent event) -> 
        {
            //Ingenting skjer når musen slippes
        }
    );
        
    }
    
    private void Tegne(GraphicsContext gc)
    {
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();
       
        gc.fill();
        gc.strokeRect
        (
            0,              //x øverst venstre hjørne
            0,              //y øverst venstre hjørne
            canvasWidth,    //bredde canvas
            canvasHeight);  //høyde canvas
        
       final ColorPicker colorPicker = new ColorPicker();
       
       colorPicker.setValue(Color.RED);
       
       gc.setStroke(colorPicker.getValue());
       
        colorPicker.setOnAction((ActionEvent t) -> {
            gc.setStroke(colorPicker.getValue());
        });
       
       // gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);     
         
    }
}




