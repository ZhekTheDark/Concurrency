package com.stress.jcip.chapter_1.paragraph_3;

import com.concurrency.jcip.chapter_1.paragraph_3.UnsafeSequence;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;

/**
 *   RESULT        SAMPLES     FREQ      EXPECT  DESCRIPTION
 *        1    133.752.817    3,36%  Acceptable  v1
 *        2  3.851.534.997   96,64%  Acceptable  v2
 */
@JCStressTest
@Outcome(id = "1", expect = ACCEPTABLE, desc = "v1")
@Outcome(id = "2", expect = ACCEPTABLE, desc = "v2")
@State()
public class UnsafeSequenceTest {

    UnsafeSequence unsafeSequence = new UnsafeSequence();

    @Actor
    public void actor1() {
        unsafeSequence.getNext();
    }

    @Actor
    public void actor2() {
        unsafeSequence.getNext();
    }

    @Arbiter
    public void arbiter(I_Result r) {
        r.r1 = unsafeSequence.value;
    }
}
