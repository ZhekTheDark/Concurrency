package com.stress.leetcode._1114_print_in_order;

import com.concurrency.leetcode._1114_print_in_order.PrintInOrder1114_Semaphore;
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
public class PrintInOrder1114_SemaphoreTest {

    private PrintInOrder1114_Semaphore.Foo foo = new PrintInOrder1114_Semaphore.Foo();

    @Actor
    public void actor1() {
        foo.first(() -> {
            foo.result += "1";
        });
    }

    @Actor
    public void actor2() {
        foo.second(() -> {
            foo.result += "2";
        });
    }

    @Actor
    public void actor3() {
        foo.third(() -> {
            foo.result += "3";
        });
    }

    @Arbiter
    public void arbiter(L_Result r) {
        r.r1 = foo.result;
    }
}
