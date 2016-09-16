package com.peterpotts.sample

import org.scalatest.{Matchers, WordSpec}

class SampleTuple2Test extends WordSpec with Matchers {
  "A sample tuple 2 instance" should {
    "generate tuple 2 values" in {
      case class Person(age: Int, name: String)
      case object SamplePerson extends MapSample(SampleTuple2(SampleInt, SampleString), Person.tupled)
      SamplePerson.next(): Person
    }
  }
}
