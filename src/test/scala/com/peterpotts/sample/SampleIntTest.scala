package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleIntTest extends WordSpec with Matchers {
  "A sample int instance" should {
    "generate int values" in {
      SampleInt.next() should (be >= Int.MinValue and be <= Int.MaxValue)
    }

    "generate limited int values" in {
      SampleInt(10).next() should (be >= 0 and be < 10)
    }
  }
}
