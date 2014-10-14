package com.peterpotts.sample

import java.util.UUID

object SampleUsage {

  case class Person(id: UUID, name: String, age: Int, email: Option[String], friends: Seq[String])

  val SamplePerson = for {
    id <- SampleUUID
    name <- SampleString(3 to 8).map("Mr. " + _)
    age <- SampleInt(50) if age > 18
    email <- SampleOption(SampleString)
    friends <- SampleSeq(SampleString, 0 to 10)
  } yield Person(id, name, age, email, friends)

  def main(args: Array[String]) {
    println(SamplePerson.next())
    println(SampleSeq(SamplePerson.distinctBy(_.name)).next())
  }
}
