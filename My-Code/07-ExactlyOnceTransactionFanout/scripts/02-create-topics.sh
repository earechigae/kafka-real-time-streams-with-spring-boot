echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic avro-pos-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic avro-pos-topic

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic avro-hadoop-sink-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic avro-hadoop-sink-topic

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic avro-loyalty-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic avro-loyalty-topic
