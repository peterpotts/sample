package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleUnitTest extends WordSpec with Matchers {
  "A sample unit instance" should {
    "generate unit values" in {
      SampleUnit.next() should equal(())
    }
  }
}
