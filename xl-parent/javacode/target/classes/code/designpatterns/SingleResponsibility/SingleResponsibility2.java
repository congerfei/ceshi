package code.designpatterns.SingleResponsibility;

/**
 * Author: Administrator
 * date :2020/7/28/028 23:33
 * description:单一原则示例
 */
public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托");
        roadVehicle.run("汽车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

    }

}

//1.遵守单一职责原则
//2.但是这样的改动很大，即将类分解，同时修改客户端
class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在路上运行。。。");
    }

}

class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在天空运行。。。");
    }

}
