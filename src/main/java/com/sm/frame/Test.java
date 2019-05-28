//package com.sm.frame;
//
//import com.sm.entity.CClass;
//import com.sm.factory.ServiceFactory;
//
//import java.util.List;
//import java.util.Map;
//
//public class Test {
//    private static int studentCount;
//    public static void main(String[] args) {
//
//        List<Map> mapList = ServiceFactory.getCClassServiceInstance().selectClassInfo();
//        mapList.forEach(map -> {
//            studentCount = (int) map.get("studentCount");
//            CClass cClass = (CClass) map.get("cClass");
//            System.out.println(studentCount);
//        });
//
//    }
//}
