echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic user-master"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic user-master

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic user-login"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic user-login