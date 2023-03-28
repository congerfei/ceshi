package code.designpatterns.factorymethod;

/**
 * Author: Administrator
 * date :2020/8/6/006 22:32
 * description: 简单工厂
 */
public class VehicleFactory {

    public Car createCar(){
        //before processiong
        return new Car();
    }

    public Plane createPlane(){
        return new Plane();
    }


}
