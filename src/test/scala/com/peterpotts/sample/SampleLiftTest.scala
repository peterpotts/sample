package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleLiftTest extends WordSpec with Matchers {
  "A sample lift instance" should {
    "generate lifted values" in {
      SampleLift("stone").next() should equal("stone")
    }
  }
}
