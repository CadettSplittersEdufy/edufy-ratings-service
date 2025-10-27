@echo off
echo Stopping edufy-ratings-service
docker stop edufy-ratings-service
echo Deleting container edufy-ratings-service
docker rm edufy-ratings-service
echo Deleting image edufy-ratings-service
docker rmi edufy-ratings-service
echo Running mvn package
call mvn package -DskipTests
echo Creating image edufy-ratings-service
docker build -t edufy-ratings-service .
echo Creating and running container edufy-ratings-service
docker run -d -p 4585:4585 --name edufy-ratings-service --network cadett-splitters-net edufy-ratings-service
echo Done!