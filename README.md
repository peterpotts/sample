Sample
======

Sample is a monadic random data generator.

Description
-----------

In a typical application, there is a need to generator sample data for unit tests. Usually, the sample data is
arbitrary, simplistic and worse still it is usually brittle. For example, suppose that many tests rely on sample
instances of some case class. If the case class is ever modified, then many tests may have to be modified, even
though this change should not have impacted them. This library helps to remove the need for magic values and
makes tests less brittle.

Usage
-----

Consider an example case class for a person entity:

    case class Person(
        id: UUID,
        name: String,
        age: Int,
        email: Option[String],
        friends: Seq[String])

There are a few way to create a sample person generator.

Using SampleTuple5:

    object SamplePerson extends MapSample(SampleTuple5(
      SampleUUID,
      SampleString(3 to 8).map("Mr. " + _),
      SampleInt(50).filter(_ > 18),
      SampleOption(SampleString),
      SampleSeq(SampleString, 0 to 10)), Person.tupled)

Using SampleIdentity:

    object SamplePerson extends SampleIdentity(
      for {
        id <- SampleUUID
        name <- SampleString(3 to 8).map("Mr. " + _)
        age <- SampleInt(50) if age > 18
        email <- SampleOption(SampleString)
        friends <- SampleSeq(SampleString, 0 to 10)
      } yield Person(id, name, age, email, friends))

Using a variable like an object:

    val SamplePerson = for {
      id <- SampleUUID
      name <- SampleString(3 to 8).map("Mr. " + _)
      age <- SampleInt(50) if age > 18
      email <- SampleOption(SampleString)
      friends <- SampleSeq(SampleString, 0 to 10)
    } yield Person(id, name, age, email, friends)

A sample person is generated using the next method:

    val person: Person = SamplePerson.next()

A sample sequence of persons with distinct names is generated like this:

    val persons: Seq[Person] = SampleSeq(SamplePerson.distinctBy(_.name)).next()
