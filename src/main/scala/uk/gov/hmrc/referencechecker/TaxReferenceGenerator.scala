package uk.gov.hmrc.referencechecker

import java.io.FileWriter

import scala.io.Source

object TaxReferenceGenerator extends App {


  def generateVat(file: String) = {
    val output = new FileWriter(file)

    var base = 100000000L
    var count = 0
    while (count < 1000000L) {
      val s = f"$base%09d"
      if (VatReferenceChecker.isValid(s)) {
        output.write(s"$s\n")
      }
      base = base + 1
      count = count + 1
    }
    output.close()
    val allValid = Source.fromFile(file).getLines().forall(l => VatReferenceChecker.isValid(l))
    println("Finished vat. All valid: " + allValid)
  }

  def generateUtr(file: String) = {
    val output = new FileWriter(file)

    var base = 1000000000L
    var count = 0
    while (count < 5000000L) {
      val s = f"$base%010d"
      if (SelfAssessmentReferenceChecker.isValid(s)) {
        output.write(s"$s\n")
      }
      base = base + 1
      count = count + 1
    }
    output.close()
    val allValid = Source.fromFile(file).getLines().forall(l => SelfAssessmentReferenceChecker.isValid(l))
    println("Finished utr. All valid: " + allValid)
  }


  def generateEpaye(file: String) = {
    val output = new FileWriter(file)

    var base = 10000000L
    var count = 0
    while (count < 2000000L) {
      val s = f"120PY$base%08d"
      if (EpayeReferenceChecker.isValid(s)) {
        output.write(s"$s\n")
      }
      base = base + 1
      count = count + 1
    }
    output.close()
    val allValid = Source.fromFile(file).getLines().forall(l => EpayeReferenceChecker.isValid(l))
    println("Finished epaye. All valid: " + allValid)
  }


  def generateSdlt(file: String) = {
    val output = new FileWriter(file)

    var base = 100000000L
    var count = 0
    while (count < 1000000L) {
      val s = f"$base%09dMA"
      if (SdltReferenceChecker.isValid(s)) {
        output.write(s"$s\n")
      }
      base = base + 1
      count = count + 1
    }
    output.close()
    val allValid = Source.fromFile(file).getLines().forall(l => SdltReferenceChecker.isValid(l))
    println("Finished sdlt. All valid: " + allValid)
  }

  def generateOther(file: String) = {
    val output = new FileWriter(file)

    var base = 1000000000000L
    var count = 0
    while (count < 1000000L) {
      val s = f"XA$base%013d"
      if (OtherTaxReferenceChecker.isValid(s)) {
        output.write(s"$s\n")
      }
      base = base + 1
      count = count + 1
    }
    output.close()
    val allValid = Source.fromFile(file).getLines().forall(l => OtherTaxReferenceChecker.isValid(l))
    println("Finished other. All valid: " + allValid)
  }

  // this simple program generates valid tax references to files.
  // simply run it and you should find files in baseDir
  val baseDir = "//Users/pawel"
//  generateVat(baseDir + "/vat.txt")
  generateUtr(baseDir + "/utr.txt")
//  generateEpaye(baseDir + "/epaye.txt")
//  generateSdlt(baseDir + "/sldt.txt")
//  generateOther(baseDir + "/other.txt")

  println("All done")


}