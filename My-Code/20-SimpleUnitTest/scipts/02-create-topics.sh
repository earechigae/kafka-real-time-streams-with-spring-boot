echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic input-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic input-topic

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic output-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic output-topic