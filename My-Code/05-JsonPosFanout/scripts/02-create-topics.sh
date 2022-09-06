echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic pos-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic pos-topic

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic loyalty-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic loyalty-topic

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic hadoop-sink-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic hadoop-sink-topic
