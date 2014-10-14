package com.peterpotts.sample

import java.util.UUID

case object SampleUUID extends Sample[UUID] {
  def next(): UUID = UUID.randomUUID
}
