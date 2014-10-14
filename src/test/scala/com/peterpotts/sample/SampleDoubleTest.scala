package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleDoubleTest extends WordSpec with Matchers {
  "A sample double instance" should {
    "generate double values" in {
      SampleDouble.next() should (be >= Double.MinValue and be <= Double.MaxValue)
    }
  }
}
