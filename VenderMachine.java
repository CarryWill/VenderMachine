package com.zj.ww;
import java.util.Scanner;


public class VenderMachine {
    /*属性：即成员变量
        比如：品牌，高度，容量
        商品列表：贩售机中包含的各种商品
        文字说明
     */
    String brand="友宝";//品牌
    int height=130;//高度
    int volume=300;//容量
    //商品列表
    Good[] goodList=new Good[5];
            //{ Coke,Milk,Noodle,Tea,Water};

    //使用说明
    String prompt="1、投钱\n" +
            "观察售货机外观，找到自己中意的商品以及价格和纸币、硬币投钱入口，然后投入相应的金额现金;\n"
            + "2、选货\n"
            +"按下自己中意的饮料对应的按钮\n"
            +"3、取货\n" +
            "饮料自动售货机下面有个取物口，打开取物口拿出饮料，格子柜是对应的门自动弹开，取出里面的商品即可。\n"
            +"4、找零\n"+
            "由于是用的现金支付，就可能存在找零的情况。如果投入的金额大于商品的定价，只需拨动退币拨杆或按下退币按钮即可，找零会以硬币的形式落入退币口，取出零钱，现金自助购物完成。\n";


    /*行为：方法
        1.收钱
        2.出货，找零
        3.提示
    */
    public void insertMoney(int money, int index) {
        //首先，查找（一种是商品不存在，一种是商品卖完了），
        // 用户将要购买的商品，是否存在，如果没有就提示，并返回
        int i = getI(index);
        //容错处理
        if (index<110 || index>114  || goodList[i].num == 0) {
            System.out.println("您选择的商品不存在或已售空，请重新选择！");
            System.exit(-1);
        }
        //用户能不能达到购买条件，如果达不到购买条件，则提示用户，通时结束方法
        if (money < goodList[i].price) {
            System.out.println("您的钱数不够，请满足交易条件再来！");
            System.exit(-1);
        }
        //找到商品并出货(是否应该，判断是否应该找零，如果刚好则不找零，
        // 如果需要找零，则找零)
        if (goodList[i].price < money) {
            int j = goodList[i].price;
            j = money - j;
            setOut(j);
            System.out.println("找零："+j+"元");
        }
        out(goodList[i].index);
        System.out.println("出货："+goodList[i].name);
        goodList[i].num--;
    }
//查找方法
    private int getI(int index) {
        Good Coke=new Good("可口可乐",3,110,6);
        Good Milk=new Good("蒙牛牛奶",3,111,8);
        Good Noodle=new Good("康师傅红烧牛肉面",5,112,6);
        Good Tea=new Good("统一冰红茶",4,113,8);
        Good Water=new Good("农夫山泉",2,114,10);
        int i=index-110;
        switch(i){
            case 0:
                goodList[i]=Coke;
                break;
            case 1:
                goodList[i]=Milk;
                break;
            case 2:
                goodList[i]=Noodle;
                break;
            case 3:
                goodList[i]=Tea;
                break;
            case 4:
                goodList[i]=Water;
                break;
        }
        return i;
    }
//出货找零的方法

    public int  setOut(int money){//找零
        return money;
    }
    public String out(int index){//出货
        //Good[] goodlist=new Good[5];
        //Good good=new Good();
       int i=index-110;
        return goodList[i].name;
    }
}
// 假设，我用Good这个类，来表示可口可乐
// 用Good类对象表示某一类商品

class Good {
    String name;
    int price;
    int index;
    int num;

    public Good(String i, int j, int k, int l) {
        getName(i);
        getPrice(j);
        getIndex(k);
        getNum(l);
    }

    public int getIndex(int i) {
        return index=i;
    }

    public int getNum(int i) {
        return num=i;
    }

    public int getPrice(int i) {
        return price=i;
    }

    public String getName(String i) {
        return name=i;
    }

    @Override
    public String toString() {

        return "good{" + "name='" + name + '\'' + ", price=" + price + ", index=" + index + '}';
    }

    public static void main(String[] args) {
        VenderMachine v=new VenderMachine();
        System.out.println("自动售货机品牌："+v.brand+"\n"+"使用说明："+v.prompt+"\n"+"高度："+v.height+"\n"+"容量："+v.volume);

        print();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入索引号：");
        int a=sc.nextInt();

        System.out.println("请投入人民币：");
        int b=sc.nextInt();
        v.insertMoney(b,a);
    }

    private static void print() {
        Good Coke=new Good("可口可乐",3,110,6);
        Good Milk=new Good("蒙牛牛奶",3,111,8);
        Good Noodle=new Good("康师傅红烧牛肉面",5,112,6);
        Good Tea=new Good("统一冰红茶",4,113,8);
        Good Water=new Good("农夫山泉",2,114,10);
        System.out.print(Water+"\n"+Tea+"\n"+Noodle+"\n"+Milk+"\n"+Coke+"\n\t");
    }
}
