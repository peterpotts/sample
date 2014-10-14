package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleBooleanTest extends WordSpec with Matchers {
  "A sample boolean instance" should {
    "generate boolean values" in {
      SampleBoolean.next() should (equal(true) or equal(false))
    }
  }
}
