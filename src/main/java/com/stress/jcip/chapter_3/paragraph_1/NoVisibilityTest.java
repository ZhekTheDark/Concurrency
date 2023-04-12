package com.stress.jcip.chapter_3.paragraph_1;

import com.concurrency.jcip.chapter_3.paragraph_1.NoVisibility;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IZ_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;

/**
 *      RESULT        SAMPLES     FREQ      EXPECT  DESCRIPTION
 *    0, false              0    0,00%  Acceptable  v4
 *     0, true              0    0,00%  Acceptable  v2
 *   42, false              0    0,00%  Acceptable  v3
 *    42, true  5.178.186.374  100,00%  Acceptable  v1
 */
@JCStressTest
@Outcome(id = "42, true", expect = ACCEPTABLE, desc = "v1")
@Outcome(id = "0, true", expect = ACCEPTABLE, desc = "v2")
@Outcome(id = "42, false", expect = ACCEPTABLE, desc = "v3")
@Outcome(id = "0, false", expect = ACCEPTABLE, desc = "v4")
@State()
public class NoVisibilityTest {

    @Actor
    public void actor1() {
        NoVisibility.t1();
    }

    @Actor
    public void actor2() {
        NoVisibility.t2();
    }

    @Arbiter
    public void arbiter(IZ_Result r) {
        r.r1 = NoVisibility.number;
        r.r2 = NoVisibility.ready;
    }
}
