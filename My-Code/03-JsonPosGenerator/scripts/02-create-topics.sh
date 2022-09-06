echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 3 --topic pos-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic pos-topic
