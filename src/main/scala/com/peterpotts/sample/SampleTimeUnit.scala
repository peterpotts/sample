package com.peterpotts.sample

import scala.collection.immutable.IndexedSeq
import scala.concurrent.duration.{DAYS, HOURS, MINUTES}

object SampleTimeUnit extends SamplePick(IndexedSeq(DAYS, HOURS, MINUTES))
