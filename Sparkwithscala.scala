//using spark shell ,scala take the json file and put it into hive table using case classes,handling null values
//step1-put the json file from local machine to hdfs 
//by haddop fs -put frst.json
//step2-start the spark-shell (here we are using 1.6.0-spark version)
val sqlContext=new org.apache.spark.sql.SQLContext(sc)
case classes Survey(Name:String,Occupation:String)
val ds=sqlContext.read.json("survey.json")as[Survey]
ds.show()
//defining a user defined function for applying on column to handle with null values
sqlContext.udf.register("Replacement Null",(s.String)=>{if(s==" ") null else s})
sqlContext.sql("select Name,ReplaceNull(Occupation)as newOccupation fromSurvey").show()
ds.registerTable("Survey")
