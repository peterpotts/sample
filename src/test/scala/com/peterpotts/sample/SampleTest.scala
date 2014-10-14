package com.peterpotts.sample

import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class SampleTest extends WordSpec with Matchers with MockitoSugar {
  "A sample instance" should {
    "generate mapped values" in {
      val sample = mock[Sample[Int]]
      when(sample.next()) thenReturn 12
      new MapSample(sample, (_: Int).toString).next() should equal("12")
    }

    "generate filtered values" in {
      val sample = mock[Sample[Boolean]]
      when(sample.next()) thenReturn(false, false, true)
      new FilterSample(sample, identity[Boolean]).next() should equal(true)
    }

    "generate distinct values" in {
      val sample = mock[Sample[Int]]
      when(sample.next()) thenReturn(1, 3, 4)
      val isEven: Int => Boolean = _ % 2 == 0
      val distinct = new DistinctBySample[Int, Boolean](sample, isEven)
      distinct.next() should equal(1)
      distinct.next() should equal(4)
    }
  }
}
