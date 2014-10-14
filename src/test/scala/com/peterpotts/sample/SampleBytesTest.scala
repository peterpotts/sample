package com.peterpotts.sample

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleBytesTest extends WordSpec with Matchers {
  "A sample bytes instance" should {
    "generate default byte arrays" in {
      SampleBytes.next().length == defaultSampleSize
    }

    "generate limited byte arrays" in {
      SampleBytes(42).next().length == 42
    }
  }
}
