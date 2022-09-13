package test

import org.apache.spark.sql.SparkSession

object TestSample:

  @main def run =
    val appName: String = "test"
    val spark = SparkSession.builder
      .appName(appName)
      .master(sys.env.getOrElse("SPARK_MASTER_URL", "local[*]"))
      .getOrCreate() // 1
    import spark.implicits._ // 2

    val df = appName.split('.').toList.toDF // 3
    df.show() // 4

    spark.stop
