
echo "kafka-topics --create --bootstrapserver localhost:9092 --replication-factor 1 --partitions 1 --topic stock-tick-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic stock-tick-topic