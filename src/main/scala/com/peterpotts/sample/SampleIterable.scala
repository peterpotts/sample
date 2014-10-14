package com.peterpotts.sample

case class SampleIterable[A](iterable: Iterable[Sample[A]]) extends Sample[Iterable[A]] {
  def next(): Iterable[A] = iterable.map(_.next())
}
