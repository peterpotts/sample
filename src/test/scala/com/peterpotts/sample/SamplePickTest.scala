package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SamplePickTest extends WordSpec with Matchers {
  "A sample pick instance" should {
    "pick values" in {
      val animals = Seq("cat", "dog")
      val animal = SamplePick(animals).next()
      animals.contains(animal) should equal(true)
    }
  }
}
