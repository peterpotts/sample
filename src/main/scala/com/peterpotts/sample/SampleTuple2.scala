package com.peterpotts.sample

case class SampleTuple2[A, B](sampleA: Sample[A], sampleB: Sample[B]) extends SampleIdentity(
  for {
    a <- sampleA
    b <- sampleB
  } yield Tuple2(a, b))

case class SampleTuple3[A, B, C](sampleA: Sample[A], sampleB: Sample[B], sampleC: Sample[C]) extends SampleIdentity(
  for {
    a <- sampleA
    b <- sampleB
    c <- sampleC
  } yield Tuple3(a, b, c))

case class SampleTuple4[A, B, C, D](
  sampleA: Sample[A],
  sampleB: Sample[B],
  sampleC: Sample[C],
  sampleD: Sample[D]) extends SampleIdentity(
  for {
    a <- sampleA
    b <- sampleB
    c <- sampleC
    d <- sampleD
  } yield Tuple4(a, b, c, d))

case class SampleTuple5[A, B, C, D, E](
  sampleA: Sample[A],
  sampleB: Sample[B],
  sampleC: Sample[C],
  sampleD: Sample[D],
  sampleE: Sample[E]) extends SampleIdentity(
  for {
    a <- sampleA
    b <- sampleB
    c <- sampleC
    d <- sampleD
    e <- sampleE
  } yield Tuple5(a, b, c, d, e))

case class SampleTuple6[A, B, C, D, E, F](
  sampleA: Sample[A],
  sampleB: Sample[B],
  sampleC: Sample[C],
  sampleD: Sample[D],
  sampleE: Sample[E],
  sampleF: Sample[F]) extends SampleIdentity(
  for {
    a <- sampleA
    b <- sampleB
    c <- sampleC
    d <- sampleD
    e <- sampleE
    f <- sampleF
  } yield Tuple6(a, b, c, d, e, f))

case class SampleTuple7[A, B, C, D, E, F, G](
  sampleA: Sample[A],
  sampleB: Sample[B],
  sampleC: Sample[C],
  sampleD: Sample[D],
  sampleE: Sample[E],
  sampleF: Sample[F],
  sampleG: Sample[G]) extends SampleIdentity(
  for {
    a <- sampleA
    b <- sampleB
    c <- sampleC
    d <- sampleD
    e <- sampleE
    f <- sampleF
    g <- sampleG
  } yield Tuple7(a, b, c, d, e, f, g))

case class SampleTuple8[A, B, C, D, E, F, G, H](
  sampleA: Sample[A],
  sampleB: Sample[B],
  sampleC: Sample[C],
  sampleD: Sample[D],
  sampleE: Sample[E],
  sampleF: Sample[F],
  sampleG: Sample[G],
  sampleH: Sample[H]) extends SampleIdentity(
  for {
    a <- sampleA
    b <- sampleB
    c <- sampleC
    d <- sampleD
    e <- sampleE
    f <- sampleF
    g <- sampleG
    h <- sampleH
  } yield Tuple8(a, b, c, d, e, f, g, h))
