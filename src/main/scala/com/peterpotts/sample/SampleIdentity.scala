package com.peterpotts.sample

class SampleIdentity[A](sampleA: Sample[A]) extends Sample[A] {
  def next(): A = sampleA.next()
}
