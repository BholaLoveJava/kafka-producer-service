# kafka-producer-service
Kafka Producer Application

##Start Zookeeper on windows machine
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

##Start Kafka Server on windows machine
.\bin\windows\kafka-server-start.bat .\config\server.properties


##Start Zookeeper on MAC and Linux
bin/zookeeper-server-start.sh config/zookeeper.properties

##Start Kafka Server on MAC and Linux
bin/kafka-server-start.sh config/server.properties

##Topic Creation command
##For Mac and Linux: 
bin/kafka-topics.sh –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic topic_name

##For Windows machine: 
.\bin\windows\kafka-topics.bat –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic kafka_example

##Now to see the messages on the Kafka server in the real-time, use the command below:
##For MAC and Linux: 
bin/kafka-console-consumer.sh –bootstrap-server localhost:9092 –topic topic_name –from-beginning

##For Windows Machine 
.\bin\windows\kafka-console-consumer.bat –bootstrap-server localhost:9092 –topic kafka_example –from-beginning

##Publish simple Message to Kakfa Topic
## HTTP Method : GET
## Request URL : http://localhost:9094/kafka/producer/publish/hello harish

##Public JSON Message to Kafka Topic
## HTTP Method : POST
## Request URL : http://localhost:9094/kafka/producer/publish/json
##Input JSON Request Body
{
   "name":"Bhola Yadav",
    "department":"IT Engineering",
    "salary": 20000.00,
    "address":"Grugaon" 
}
