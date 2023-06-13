# ChannelStreamer
ChannelStreamer
PreRequisite: run the below docker command to run rabbitMQ server as docker container


docker run -d --hostname prem-rabbitMQ --name prem-rabbitMQ -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password -p 5672:5672 -p 15672:15672 rabbitmq:3-management

It will take a couple of minutes for rabbitMQ to completely serve requests

you can browse http://172.17.0.2:15672/#/ to check if the server is up and running

172.17.0.2 should be the container IP address.

Build:
mvn clean install

Run Application

Read from Stream1
http://localhost:8080/api/stream1/readData/{stream_limit}

example: http://localhost:8080/api/stream1/readData/20
this will read first 20 records from stream1.json

Read from Stream2
http://localhost:8080/api/stream2/readData/{stream_limit}

example: http://localhost:8080/api/stream2/readData/20
this will read first 20 records from stream2.json

Publish into Queue:
http://localhost:8080/api/queue/publish/{stream_limit}

example: http://localhost:8080/api/queue/publish/20
publishes 20 messages from the stream1 and stream2

Consume from Queue:
http://localhost:8080/api/queue/consume


Twitter Stream:
twitter4j and twitter4j.conf are pre-requisites for twitter stream to work as expected.

Mastodon Stream:
mastodon4j are pre-requisites for Mastodon stream to work as expected.

