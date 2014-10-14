package com.peterpotts

import scala.util.{Failure, Success, Try}

package object sample {
  val defaultSampleSize = 4

  val SampleAlphanumeric: Sample[Char] =
    for (index <- SampleInt(62)) yield
      if (index < 26)
        ('A' + index).toChar
      else if (index < 52)
        ('a' + index - 26).toChar
      else
        ('0' + index - 52).toChar

  val SampleString = SampleSeq(SampleAlphanumeric, defaultSampleSize).map(_.mkString)

  def SampleString(size: Int): Sample[String] = SampleString(size to size)

  def SampleString(sizes: Seq[Int]): Sample[String] = SampleSeq(SampleAlphanumeric, sizes).map(_.mkString)

  def SampleOption[A](sampleA: Sample[A]): Sample[Option[A]] = for {
    boolean <- SampleBoolean
    a <- sampleA
  } yield if (boolean) None else Some(a)

  def SampleEither[L, R](sampleL: Sample[L], sampleR: Sample[R]): Sample[Either[L, R]] = for {
    boolean <- SampleBoolean
    left <- sampleL
    right <- sampleR
  } yield if (boolean) Left(left) else Right(right)

  def SampleTry[A](sampleA: Sample[A]): Sample[Try[A]] = for {
    boolean <- SampleBoolean
    a <- sampleA
    message <- SampleString
  } yield if (boolean) Success(a) else Failure[A](new RuntimeException(message))

  def SampleSeq[A](sampleA: Sample[A], size: Int = defaultSampleSize): Sample[Seq[A]] =
    SampleIterable(Iterable.fill(size)(sampleA)).map(_.toSeq)

  def SampleSeq[A](sampleA: Sample[A], sizes: Seq[Int]): Sample[Seq[A]] = for {
    size <- SamplePick(sizes)
    seqA <- SampleSeq(sampleA, size)
  } yield seqA

  def SampleSet[A](sampleA: Sample[A], size: Int = defaultSampleSize): Sample[Set[A]] =
    SampleIterable(Iterable.fill(size)(sampleA)).map(_.toSet)

  def SampleSet[A](sampleA: Sample[A], sizes: Seq[Int]): Sample[Set[A]] = for {
    size <- SamplePick(sizes)
    setA <- SampleSet(sampleA, size)
  } yield setA

  def SamplePair[A, B](sampleA: Sample[A], sampleB: Sample[B]): Sample[(A, B)] = for {
    a <- sampleA
    b <- sampleB
  } yield (a, b)

  def SampleMap[A, B](sampleA: Sample[A], sampleB: Sample[B], sizes: Seq[Int]): Sample[Map[A, B]] =
    SampleSeq(SamplePair(sampleA, sampleB), sizes).map(_.toMap)

  def SampleMap[A, B](sampleA: Sample[A], sampleB: Sample[B], size: Int = defaultSampleSize): Sample[Map[A, B]] =
    SampleMap(sampleA, sampleB, size to size)
}