package com.stress.leetcode;

import com.concurrency.leetcode.PrintInOrder1114;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.L_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;

@JCStressTest
@Outcome(id = "123", expect = ACCEPTABLE, desc = "v1")
@Outcome(id = "132", expect = ACCEPTABLE, desc = "v2")
@Outcome(id = "213", expect = ACCEPTABLE, desc = "v3")
@Outcome(id = "231", expect = ACCEPTABLE, desc = "v4")
@Outcome(id = "312", expect = ACCEPTABLE, desc = "v5")
@Outcome(id = "321", expect = ACCEPTABLE, desc = "v6")
@State()
public class PrintInOrder1114Test {

    private PrintInOrder1114.Foo foo = new PrintInOrder1114.Foo();

    @Actor
//    public void actor1() throws InterruptedException {
    public void actor1() {
        foo.first(() -> {
            foo.result += "1";
        });
    }
//    public void actor1() {
//        try {
//            foo.first(() -> {
//                foo.result += "1";
//            });
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Actor
//    public void actor2() throws InterruptedException {
    public void actor2() {
        foo.second(() -> {
            foo.result += "2";
        });
    }
//    public void actor2() {
//        try {
//            foo.second(() -> {
//                foo.result += "2";
//            });
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Actor
//    public void actor3() throws InterruptedException {
    public void actor3() {
        foo.third(() -> {
            foo.result += "3";
        });
    }
//    public void actor3() {
//        try {
//            foo.third(() -> {
//                foo.result += "3";
//            });
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Arbiter
    public void arbiter(L_Result r) {
        r.r1 = foo.result;
    }
}
