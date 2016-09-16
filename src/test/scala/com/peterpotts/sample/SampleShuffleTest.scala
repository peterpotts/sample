package com.peterpotts.sample

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.Seq

class SampleShuffleTest extends WordSpec with Matchers {
  "A sample shuffle instance" should {
    "shuffle sample values" in {
      val animals = Seq("wolf", "bear")
      val samples = animals.map(SampleLift[String])
      val animal = SampleShuffle(samples: _*).next()
      animals.contains(animal) shouldEqual true
    }
  }
}
