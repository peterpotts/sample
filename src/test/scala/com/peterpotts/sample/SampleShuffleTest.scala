package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleShuffleTest extends WordSpec with Matchers {
  "A sample shuffle instance" should {
    "shuffle sample values" in {
      val animals = Seq("wolf", "bear")
      val samples = animals.map(SampleLift[String])
      val animal = SampleShuffle(samples: _*).next()
      animals.contains(animal) should equal(true)
    }
  }
}
