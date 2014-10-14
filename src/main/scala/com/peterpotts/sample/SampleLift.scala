package com.peterpotts.sample

case object SampleLift {
  def apply[A](a: A): Sample[A] = SampleUnit.map(_ => a)
}
