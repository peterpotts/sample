package com.peterpotts.sample

import scala.concurrent.duration.FiniteDuration

object SampleFiniteDuration extends SampleIdentity(
  for {
    length <- SamplePick(1 to 9)
    unit <- SampleTimeUnit
  } yield FiniteDuration(length, unit))
