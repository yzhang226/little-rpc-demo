package org.cook.rpc.rpc;

public class TestAnnoModel {

    @OneAnno
    public void test1() {
        System.out.println("test1");
    }

    public static void main(String[] args) {
        TestAnnoModel model = new TestAnnoModel();
        model.test1();
    }

}
