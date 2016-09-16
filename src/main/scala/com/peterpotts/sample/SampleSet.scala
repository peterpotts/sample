package com.peterpotts.sample

import scala.collection.immutable.{IndexedSeq, Iterable}

case class SampleSet[A](iterable: Iterable[Sample[A]])
  extends MapSample[Iterable[A], Set[A]](SampleIterable(iterable), _.toSet)

object SampleSet {
  def apply[A](sampleA: Sample[A], size: Int = defaultSampleSize): Sample[Set[A]] =
    new SampleSet(Iterable.fill(size)(sampleA))

  def apply[A](sampleA: Sample[A], sizes: IndexedSeq[Int]): Sample[Set[A]] =
    SamplePick(sizes).flatMap(size => apply(sampleA, size))
}
