//using spark shell ,scala take the json file and put it into hive table
//step1-put the json file from local machine to hdfs 
//by haddop fs -put frst.json
//step2-start the spark-shell (here we are using 1.6.0-spark version)
val sqlContext=new org.apache.spark.sql.SQLContext(sc)
val dataframe=sqlContext.read.json("frst.json")
dataframe.show()
//print schema of dataframe
dataframe.printSchema()
//put it in hive
dataframe.registerTempTable("mytable")
//print the table 
sparkContext.sql("select * from table").show()
