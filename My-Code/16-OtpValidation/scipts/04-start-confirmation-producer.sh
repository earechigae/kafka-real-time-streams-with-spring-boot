echo "kafka-console-producer --broker-list localhost:9092 --topic payment_confirmation --property parse.key=true --property key.separator=":""
kafka-console-producer --broker-list localhost:9092 --topic payment_confirmation --property parse.key=true --property key.separator=":"
