package code.designpatterns.SingleResponsibility;

/**
 * Author: Administrator
 * date :2020/7/28/028 23:42
 * description:单一原则的标准示例
 * 1.降低类的复杂度 2.提高类的可读性，可维护性 3.降低变更引起的风险
 */
public class SingleRespinsibility3 {

    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("汽车");
        vehicle2.runAir("飞机");
        vehicle2.runWater("游艇");
    }
}

//1.没有在类上做大的修改，只是增加方法
//2.这个方法虽热在类上没有做到单一职责原则，但是在方法上是做到了单一职责原则
class Vehicle2{

    public void run(String vehicle){
        System.out.println(vehicle+"在公路上运行。。。");
    }

    public void runAir(String vehicle){
         System.out.println(vehicle+"在天上运行。。。");
    }

    public void runWater(String vehicle){
        System.out.println(vehicle+"在水上运行。。。");
    }

}
