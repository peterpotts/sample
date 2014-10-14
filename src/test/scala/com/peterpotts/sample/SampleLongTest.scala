package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleLongTest extends WordSpec with Matchers {
  "A sample long instance" should {
    "generate long values" in {
      SampleLong.next() should (be >= Long.MinValue and be <= Long.MaxValue)
    }

    "generate limited long values" in {
      SampleLong(5L).next() should (be >= 0L and be < 5L)
    }
  }
}
