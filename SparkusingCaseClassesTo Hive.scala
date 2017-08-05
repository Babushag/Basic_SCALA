//using spark shell ,scala take the text file and put it into hive table
//step1-put the json file from local machine to hdfs 
//by haddop fs -put frst.json
//step2-start the spark-shell (here we are using 1.6.0-spark version)
val sqlContext=new org.apache.spark.sql.SQLContext(sc)
case class doctor(id:String,name:String,gender:String)
val dataframe=sc.textFile("data.txt").map{line=> val data=line.split(",").map(_.trim).
map{case ""=>null case(s:String)=>x} doctor(data(0),data(1),data(2))}.toDF()
dataframe.show()
dataframe.registerTempTable("Doctor")
