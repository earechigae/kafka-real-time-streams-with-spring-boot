echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic active-inventories"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic active-inventories

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ad-clicks"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ad-clicks