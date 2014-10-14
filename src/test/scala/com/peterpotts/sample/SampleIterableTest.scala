package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleIterableTest extends WordSpec with Matchers {
  "A sample iterable instance" should {
    "generate iterable values" in {
      val input = Iterable("flower", "tree", "grass")
      val samples = input.map(SampleLift[String])
      val output = SampleIterable(samples).next()
      output should equal(input)
    }
  }
}
