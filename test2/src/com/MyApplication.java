package com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MyApplication extends Application{
	private boolean isBlack=true;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Pane pane = getPane();//获取画板对象	
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {		
			/*public int getMax() {
				max++;
				return max;
			}*/
			
			public void handle(MouseEvent event) {
				 double x = event.getX();
				 double y = event.getY();
				 if(x<20) {
					 x=20;
				 }else if((x-20)%40>=20) {
					 x=x+40-(x-20)%40;
				 }else if((x-20)%40<20){
					 x=x-(x-20)%40;
				 }
					if(y<20) {
						y=20;
					}else if((y-20)%40<20) {
					 y=y-(y-20)%40;
				 }else if((y-20)%40>20) {
					 y=y+40-(y-20)%40;
				 }
					if(isHas(x,y)) {
						return;
					}else {
					if(isBlack) {
						Circle circle =new Circle(x,y,7.5,Color.BLACK);
						pane.getChildren().add(circle);	
						isBlack = false;
					}else {
					Circle circle =new Circle(x,y,7.5,Color.WHITE);
					pane.getChildren().add(circle);	
					isBlack =true;
					}
					}
				// TODO Auto-generated method stub
				
			}

		});
		/*Line line =new Line(50,50,50,500);//创建线条50,50为第一个坐标，50，400为第二个坐标，线连接二个坐标
		pane.getChildren().add(line);//pane.getChildren():获取一个容器，.add(line)：将线条放入容器。*/
		
		Scene scene =new Scene(pane,550,550);//场景对象,并将画板放入场景中,600为长宽
		
		stage.setScene(scene);//将场景放到舞台上
		
		stage.show();//显示舞台
		stage.setTitle("五子棋");
	}
	private Pane getPane() {
		Pane pane =new Pane();//创建画板
		pane.setBackground(new Background(new BackgroundFill(Color.AZURE, null, null)));
		for(int i=20;i<=540;i=i+40) {
			Line line =new Line(i,20,i,540);
			Line line1 =new Line(20,i,540,i);
			pane.getChildren().add(line);
			pane.getChildren().add(line1);
		}
		return pane;
	}
public static void main(String[] args) {
	launch(args);
}
private boolean isHas(double x,double y) {
	
	// TODO Auto-generated method stub
	return false;
}
}
