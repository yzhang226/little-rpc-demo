package org.cook.rpc.rpc;

@OneAnno
public class TestAnnoModel {


    public void test1() {
        System.out.println("test1");
    }

    public static void main(String[] args) {
        TestAnnoModel model = new TestAnnoModel();
        model.test1();
    }

}
