package com.peterpotts.sample

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.IndexedSeq

class SamplePickTest extends WordSpec with Matchers {
  "A sample pick instance" should {
    "pick values" in {
      val animals = IndexedSeq("cat", "dog")
      val animal = SamplePick(animals).next()
      animals.contains(animal) shouldEqual true
    }
  }
}
