package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleUUIDTest extends WordSpec with Matchers {
  "A sample UUID instance" should {
    "generate UUID values" in {
      SampleUUID.next() == SampleUUID.next() should equal(false)
    }
  }
}
