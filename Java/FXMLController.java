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
import javafx.scene.control.MenuBar;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;


public class FXMLController implements Initializable 
{
    @FXML private Canvas canvas;
    @FXML private ColorPicker colorPicker;
    @FXML private MenuBar menubar;
    GraphicsContext graphicsContext;
    double canvasWidth;
    double canvasHeight;
    int[][] array = new int[45][50];
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
      
        graphicsContext = canvas.getGraphicsContext2D();
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        graphicsContext.setLineWidth(3);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        colorPicker.setValue(Color.RED);
       
       graphicsContext.setStroke(colorPicker.getValue());
      
        Tegne();
        
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
            //kodes seinere
            //Ingenting skjer når musen slippes
        }
    );
        
    }
    
    private void Tegne()
    {
      array[1][1] = 1;
      array[0][2] = 1;
        //graphicsContext.setFill(Color.WHITE);
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i][j] == 1) graphicsContext.fillRect(i*canvasWidth/array.length, j*canvasHeight/array.length, canvasWidth/array.length, canvasHeight/array.length);
                graphicsContext.strokeRect(i*canvasWidth/array.length, j*canvasHeight/array.length, canvasWidth/array.length, canvasHeight/array.length);
                
            }
        }
       
        colorPicker.setOnAction((ActionEvent t) -> 
        {
            graphicsContext.setStroke(colorPicker.getValue());
        }

     );
              
    }
    
     public void nullstillGameboard (ActionEvent event)
   {
      
       //graphicsContext.setFill(Color.WHITE);
       graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
       //graphicsContext.setStroke(Color.BLACK);
       graphicsContext.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight()); 
       Tegne();
        

   }
    
  
}








