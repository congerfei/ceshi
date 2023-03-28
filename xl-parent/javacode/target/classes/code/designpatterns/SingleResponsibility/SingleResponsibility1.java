package code.designpatterns.SingleResponsibility;

/**
 * Author: Administrator
 * date :2020/7/28/028 23:26
 * description:单一原则错误示例
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {

        Vehicle vehicle =new Vehicle();
        vehicle.run("游艇");
        vehicle.run("汽车");
        vehicle.run("飞机");

    }

}

//1.在方式一 的run方法中，违反了单一职责原则
//2.解决的方案非常的简单，根据交通工具的运行方法不同，分解成不同类即可
class Vehicle{

    public void run(String vehicle){
        System.out.println(vehicle+"在公路上运行。。。");
    }

}
