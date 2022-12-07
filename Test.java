package He;
import java.util.Scanner;

public class Test {

    static int max = 0;
    static Students [] students = new Students[100];
    public static void main(String[] args) {
        System.out.println("欢迎使用学生成绩管理系统");
        //死循环
       while (true){
           information();
       }
    }

    public static void information() {
        System.out.println("1、添加学生成绩");
        System.out.println("2、删除学生成绩");
        System.out.println("3、修改学生成绩");
        System.out.println("4、查询学生成绩");
        System.out.println("5、退出系统");
        System.out.println("请输入操作项:");
        Scanner in = new Scanner(System.in);//输入、赋值给in
        int m = in.nextInt();
        switch (m) {
            //添加学生成绩
            case 1:{
                if(max>students.length-1) {	//判断是否满员
                    System.out.println("学生成绩录入已满");
                    return;
                }
                System.out.println("输入添加的学生信息：");
                Students student = new Students();
                System.out.println("请输入学号：");
                String id = in.next();
                student.setId(id);
                if(max>0) {
                    for (Students stu : students) {
                        if(stu == null) {	//当某个位置为null时，其后的位置都为null,不用再查找了
                            break;
                        }
                        if(stu.getId().equals(student.getId())) //判断学号是否重复
                        {
                            System.out.println("学号重复，请重新输入学号：");
                            student.setId(in.next());
                            break;
                        }
                    }
                }
                System.out.println("请输入姓名：");
                student.setName(in.next());
                System.out.println("请输入该学生的高数成绩：");
                student.setMath(in.nextDouble());
                System.out.println("请输入该学生的java成绩：");
                student.setJava(in.nextDouble());
                System.out.println("请输入该学生的英语成绩：");
                student.setEnglish(in.nextDouble());

                students[max] = student;	//把学生的信息依次填入数组中
                max++;
                System.out.println("添加成功");
                break;
            }
            //删除学生成绩
            case 2:{
                System.out.println("请输入要删除学生的学号：");
                String id = in.next();
                System.out.println("请输入要删除的学生的姓名：");
                String name=in.next();
                max=0;
                for(Students student:students) {
                    if(student == null) {
                        break;
                    }
                    if(student.getId().equals(id)&&student.getName().equals(name)) {
                        while(max<students.length-1) {
                            students[max] = students[max+1]; //把要删除学生其后的学生依次向前移一位
                            max++;
                        }
                        students[students.length-1] = null; //最后一个学生向前移一位了，所以最后一位就是null
                        System.out.println("删除成功，已返回！");
                        return;
                    }
                    max++;
                }

                System.out.println("未找到学号为"+id+"的学生，无法删除");
                return;
            }
            //修改学生成绩
            case 3:{
                System.out.println("请输入要修改的学生的学号：");
                String id = in.next();
                System.out.println("请输入要修改的学生的姓名：");
                String name=in.next();

                for(Students student:students) {
                    if(student == null) {
                        break;
                    }
                    if(student.getId().equals(id)&&student.getName().equals(name)) {
                        System.out.println("请输入新的姓名：");
                        student.setName(in.next());
                        System.out.println("请输入新的学号：");
                        student.setMath(in.nextDouble());
                        System.out.println("请输入新的高数成绩：");
                        student.setMath(in.nextDouble());
                        System.out.println("请输入新的Java成绩：");
                        student.setJava(in.nextDouble());
                        System.out.println("请输入新的英语成绩：");
                        student.setEnglish(in.nextDouble());
                        System.out.println("修改成功，已返回！");
                        return;
                    }
                }

                System.out.println("未查到学号为"+id+"的学生，无法修改！");
                return;
            }
            //查询学生成绩
            case 4:{

                boolean flag = false;
                System.out.println("查询学生成绩");
                System.out.println("请输入要查询学生的学号：");
                String id=in.next();
                System.out.println("请输入要查询学生的姓名：");
                String name = in.next();
                for(Students student: students) {
                    if(student == null) {
                        break;
                    }
                    if(student.getName().equals(name)&&student.getId().equals(id)) {
                        System.out.println(student);
                        flag = true;
                    }
                }

                if(!flag) {
                    System.out.println("姓名为"+name+"的学生不存在");
                    return;
                }
                break;
            }
            case 5:{
                System.exit(1);
            }
            default:
                System.out.println("系统未找到"+m+"操作项");
        }

    }

}


class Students {

    //Java封装
    private String id;
    private String name;
    private double math;
    private double java;
    private double english;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMath() {
        return math;
    }
    public void setMath(double math) {
        this.math = math;
    }
    public double getJava() {
        return java;
    }
    public void setJava(double java) {
        this.java = java;
    }
    public double getEnglish() {
        return english;
    }
    public void setEnglish(double english) {
        this.english = english;
    }
    @Override
    public String toString() {
        return "学号：" + id + "  姓名：" + name + "  高数成绩：" + math + "  Java成绩：" + java+"  英语成绩："+english;
    }
}
