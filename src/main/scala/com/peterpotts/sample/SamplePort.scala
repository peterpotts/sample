package com.peterpotts.sample

import java.net.{DatagramSocket, ServerSocket}

import scala.util.Try

object SamplePort extends FilterSample[Int](SamplePick(49152 to 65535), {
  port =>
    trait Protocol {
      def setReuseAddress(on: Boolean)

      def close()
    }

    val tcp = new ServerSocket(_: Int) with Protocol
    val udp = new DatagramSocket(_: Int) with Protocol
    def using[R, T](resource: R)(release: R => Unit)(use: R => T): T = try use(resource) finally release(resource)
    Try(List(tcp, udp).foreach(protocol => using(protocol(port))(_.close())(_.setReuseAddress(on = true)))).isSuccess
})
